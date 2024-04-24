package com.ph34757.sof3011.utils;

import jakarta.persistence.EntityManager;

import java.util.List;

import static com.ph34757.sof3011.utils.JpaUtils.getEntityManager;

public abstract class RepositoriesUtils<Entity, Type> {
          public EntityManager entityManager = getEntityManager();

          public abstract List<Entity> getList();

          public abstract List<Entity> listActive();

          public Entity findById(Type id) {
                    return entityManager.find(getEntityClass(), id);
          }

          public void insert(Entity entity) {
                    try {
                              entityManager.getTransaction().begin();
                              entityManager.persist(entity);
                              entityManager.getTransaction().commit();
                    } catch (Exception e) {
                              entityManager.getTransaction().rollback();
                    }
          }

          public void update(Entity entity) {
                    try {
                              entityManager.getTransaction().begin();
                              entityManager.merge(entity);
                              entityManager.getTransaction().commit();
                    } catch (Exception e) {
                              entityManager.getTransaction().rollback();
                    }
          }

          public void delete(Type id) {
                    try {
                              entityManager.getTransaction().begin();
                              Entity entity = findById(id);
                              if (entity != null) {
                                        entityManager.remove(entity);
                              }
                              entityManager.getTransaction().commit();
                    } catch (Exception e) {
                              entityManager.getTransaction().rollback();
                    }
          }

          public abstract Class<Entity> getEntityClass();

}