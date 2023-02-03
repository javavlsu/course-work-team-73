package BoardMeet.Backend.controller;

import BoardMeet.Backend.Model.TestEntity;
import BoardMeet.Backend.Model.TestEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    private TestEntityRepository testEntityRepository;

    @GetMapping
    public @ResponseBody Iterable<TestEntity> test()
    {
        return testEntityRepository.findAll();
    }
}
