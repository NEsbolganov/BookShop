package com.example.MyBookShopApp.Data.Repositories;

import com.example.MyBookShopApp.Data.TestEntity;
import org.springframework.data.repository.CrudRepository;

public interface TestEntityCrudRepository extends CrudRepository<TestEntity,Long> {
}
