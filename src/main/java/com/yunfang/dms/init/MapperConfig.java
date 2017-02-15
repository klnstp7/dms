package com.yunfang.dms.init;

import com.yunfang.dms.dto.BuildingBaseDataDto;
import com.yunfang.dms.dto.ExtendConfigDto;
import com.yunfang.dms.entity.BuildingBaseData;
import com.yunfang.dms.entity.ExtendConfig;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

/**数据实体与DTO转换关系类
 * Created by Administrator on 2017/2/6.
 */
public class MapperConfig {
    static ModelMapper modelMapper = new ModelMapper();

    public static void CreateMapping(){
        modelMapper.addMappings(
                new PropertyMap<BuildingBaseData,BuildingBaseDataDto>() {
                    protected void configure() {
                        map().setLastUpdateTime(source.getLastUpdateTime());
                    }}
        );

        modelMapper.addMappings(
                new PropertyMap<BuildingBaseDataDto,BuildingBaseData>() {
                    protected void configure() {
                        map().setLastUpdateTime(source.getLastUpdateTime());
                    }}
        );

//        modelMapper.addMappings(
//                new PropertyMap<ExtendConfigDto,ExtendConfig>() {
//                    protected void configure() {
//                        map().setSourceTable(source.getSourceTable());
//                    }}
//        );

//        modelMapper.addMappings(
//                new PropertyMap<ExtendConfig,ExtendConfigDto>() {
//                    protected void configure() {
//                        map().setSourceTable(source.getSourceTable());
//                    }}
//        );
    }

    /**
     * 实体转DTO
     * @param source 源实体
     * @param destinationType 目标实体类型
     * @param <T>
     * @return
     */
    public static <T> T map(Object source, Class<T> destinationType){
        return modelMapper.map(source, destinationType);
    }
}
