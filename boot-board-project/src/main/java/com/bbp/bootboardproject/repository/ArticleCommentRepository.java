package com.bbp.bootboardproject.repository;

import com.bbp.bootboardproject.domain.ArticleComment;
import com.bbp.bootboardproject.domain.QArticle;
import com.bbp.bootboardproject.domain.QArticleComment;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArticleCommentRepository extends
        JpaRepository<ArticleComment, Long>,
        QuerydslPredicateExecutor<ArticleComment>, //ArticleComment 안에 모든 필드에 대한 검색기능을 추가해줌! 하지만 부분검색과 같은 부가기능이 없다..
        QuerydslBinderCustomizer<QArticleComment>
{
    @Override
    default void customize(QuerydslBindings bindings, QArticleComment root) {
        bindings.excludeUnlistedProperties(true); // 필요한 필터만 사용되게 true
        bindings.including(root.content,root.createdAt, root.createdBy); // 선택 추가
        // bindings.bind(root.title).first(StringExpression::likeIgnoreCase); like '${v}' 수동으로 %를 넣고 싶을 때
        bindings.bind(root.content).first(StringExpression::containsIgnoreCase); // like '%${v}%'
        bindings.bind(root.createdAt).first(DateTimeExpression::eq);
        bindings.bind(root.createdBy).first(StringExpression::containsIgnoreCase);
    }
}