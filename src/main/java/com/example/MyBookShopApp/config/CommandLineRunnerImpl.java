package com.example.MyBookShopApp.config;

import com.example.MyBookShopApp.data.TestEntity;
import com.example.MyBookShopApp.data.repositories.TestEntityCrudRepository;
import org.springframework.boot.CommandLineRunner;

//@Configuration
public class CommandLineRunnerImpl implements CommandLineRunner {
    TestEntityCrudRepository testEntityCrudRepository;

//    @Autowired
    public CommandLineRunnerImpl(TestEntityCrudRepository testEntityCrudRepository) {
        this.testEntityCrudRepository = testEntityCrudRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        /*
        for (int i = 0; i < 5; i++) {
            createTestEntity(new TestEntity());
        }

        TestEntity readTestEntity = readTestEntityById(3L);
        if(readTestEntity != null){
            Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName()).info("read "+readTestEntity.toString());
        }else{
            throw new NullPointerException();
        }

        TestEntity updatedEntity = updateTestEntityById(5L);
        if(updatedEntity != null){
            Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName()).info("update "+updatedEntity.toString());
        }else{
            throw new NullPointerException();
        }

        deleteTestEntityById(4L);

         */
    }

    private void deleteTestEntityById(Long id) {
        TestEntity testEntity = testEntityCrudRepository.findById(id).get();
        testEntityCrudRepository.delete(testEntity);
    }

    private TestEntity updateTestEntityById(Long id) {
        TestEntity testEntity = testEntityCrudRepository.findById(id).get();
        testEntity.setData("NEW DATA");
        testEntityCrudRepository.save(testEntity);
        return testEntity;
    }

    private TestEntity readTestEntityById(Long id) {
        return testEntityCrudRepository.findById(id).get();
    }

    private void createTestEntity(TestEntity testEntity) {
        testEntity.setData(testEntity.getClass().getSimpleName()+hashCode());
        testEntityCrudRepository.save(testEntity);
    }
}
