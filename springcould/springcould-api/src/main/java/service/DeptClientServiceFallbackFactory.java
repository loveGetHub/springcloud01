package service;

import entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component//不能忘
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(long id) {
                return new Dept().setDeptno(id).setDname("该ID:"+id+"没有对应的值，Consumer客户端提供降级信息，此刻服务Provider以关闭").setDb_source("mysql没有这个数据库");
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}
