import com.yunfang.dms.dto.BuildingBaseDataDto;
import com.yunfang.dms.entity.BuildingBaseDataCond;
import com.yunfang.dms.service.inter.IBuildingBaseDataService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/2/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class BuildingBaseDataTest {
    @Autowired
    private IBuildingBaseDataService buildingService;

    @Test
    public void insertTest(){
        BuildingBaseDataDto dto = new BuildingBaseDataDto();
        dto.setAddress("北京市西城区车公庄大街10号");
        dto.setBuildingAlias("北京市西城区车公庄大街10号");
        dto.setBuildingName("1号楼");
        dto.setBuildYear("2015");
        dto.setCityName("上海");
        dto.setCommunity("五栋大楼");
        dto.setCreateDatetime(new Date());
        dto.setLastUpdateTime(new Date());
        dto.setRegion("西城区");
        dto.setDistrict("西城区");
        dto.setExtendCol("户号:123,绿化率:100%");
        dto.setCompanyId(100);

        Boolean result = buildingService.insert(dto);
        Assert.assertTrue(result);
    }

    @Test
    public void updateTest(){
        BuildingBaseDataDto dto = new BuildingBaseDataDto();

        dto.setAddress("北京市西城区车公庄大街10号");
        dto.setBuildingAlias("北京市西城区车公庄大街10号");
        dto.setBuildingName("1号楼");
        dto.setBuildYear("2015");
        dto.setCityName("北京");
        dto.setCommunity("富力大厦");
        dto.setCreateDatetime(new Date());
        dto.setLastUpdateTime(new Date());
        dto.setRegion("西城区");
        dto.setDistrict("西城区");
        dto.setExtendCol("户号:123,绿化率:100%");
        dto.setCompanyId(100);
        dto.setId(new Long(12));

        Boolean result = buildingService.update(dto);
        Assert.assertTrue(result);
    }

    @Test
    public void deleteTest(){

        Boolean result = buildingService.delete(new Long(12));
        Assert.assertTrue(result);
    }

    @Test
    public void getTest(){
        Long id = new Long(15);
        BuildingBaseDataDto result = buildingService.get(id);
        Assert.assertEquals(id,result.getId());
    }

    @Test
    public void selectByCondTest(){
        BuildingBaseDataCond cond = new BuildingBaseDataCond();
        BuildingBaseDataCond.Criteria criteria = cond.createCriteria();
        criteria.andCityNameEqualTo("北京").andCommunityEqualTo("富力大厦");

        List<BuildingBaseDataDto> result = buildingService.selectByCond(cond);
        Assert.assertEquals(1,result.size());
    }
}
