package com.project.search.utils;

import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import java.util.List;
import java.util.stream.Collectors;

@Component
@ActiveProfiles("test")
public class DatabaseCleanup {
    @PersistenceContext
    private EntityManager entityManager;

    private List<String> tableNames;

    public void initializeTablesNames() {
        tableNames = entityManager.getMetamodel()
                .getEntities()
                .stream()
                .filter(e -> e.getJavaType().getAnnotation(Entity.class) != null)
                .map(e -> e.getJavaType().getAnnotation(Table.class).name())
                .collect(Collectors.toList());
    }

    @PostConstruct
    public void databaseCleanupPostConstructor() {
        initializeTablesNames();
    }

    @Transactional
    public void execute() {
        entityManager.flush();
//        entityManager.createNativeQuery("SET @@foreign_key_checks = 0;").executeUpdate();
        entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY FALSE").executeUpdate();

        for (String tableName : tableNames) {
            entityManager.createNativeQuery("DROP TABLE IF EXISTS " + tableName + " CASCADE").executeUpdate();
        }

//        entityManager.createNativeQuery("SET @@foreign_key_checks = 1;").executeUpdate();
        entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY TRUE").executeUpdate();
    }
}
