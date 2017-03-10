import com.yunfang.dms.dto.ExtendConfigDto;
import com.yunfang.dms.entity.ExtendConfigCond;
import com.yunfang.dms.exception.CustomException;
import com.yunfang.dms.service.inter.IExtendConfigService;
import com.yunfang.dms.enums.SourceTableEmum;
import com.yunfang.dms.utils.ExcelUtil;
import org.apache.poi.ss.formula.functions.T;
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
public class ExtendConfigTest {
    @Autowired
    private IExtendConfigService buildingService;

    @Test
    public void insertTest(){
        ExtendConfigDto dto = new ExtendConfigDto();
        dto.setCompanyId(1);
        dto.setSourceTable(SourceTableEmum.InquiryData);
        dto.setColumnName("天台");
        dto.setCreateDateTime(new Date());
        dto.setOperator("lthui");
        try{
            Boolean result = buildingService.insert(dto);
            Assert.assertTrue(result);
        }
        catch (CustomException ex){
            Assert.assertTrue(false);
        }
    }

    @Test
    public void deleteTest(){
        Long id=new Long(1);
        try{
            Boolean result = buildingService.delete(id,1);
            if(!result){
                result= buildingService.delete(id++,1);
            }
            Assert.assertTrue(result);}
        catch (CustomException ex){
            Assert.assertTrue(false);
        }
    }

    @Test
    public void getTest(){
        Long id = new Long(15);
        ExtendConfigDto result = buildingService.get(id);
        Assert.assertEquals(id,result.getId());
    }

    @Test
    public void selectByCondTest(){
        ExtendConfigCond cond = new ExtendConfigCond();
//        ExtendConfigCond.Criteria criteria = cond.createCriteria();
        cond.createCriteria().andCompanyIdEqualTo(1);
        List<ExtendConfigDto> result = buildingService.selectByCond(cond);
        Assert.assertNotNull(result);
    }
}
