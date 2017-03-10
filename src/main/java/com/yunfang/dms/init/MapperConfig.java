package com.yunfang.dms.init;

import com.mysql.fabric.xmlrpc.base.Data;
import com.yunfang.dms.dto.*;
import com.yunfang.dms.entity.*;
import com.yunfang.dms.utils.ClassRefUtil;
import org.apache.poi.ss.formula.functions.T;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.cglib.beans.BeanCopier;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 数据实体与DTO转换关系类
 * Created by Administrator on 2017/2/6.
 */
public class MapperConfig {
    static ModelMapper modelMapper = new ModelMapper();

    public static void CreateMapping() {
        modelMapper.addMappings(
                new PropertyMap<BuildingBaseData, BuildingBaseDataDto>() {
                    protected void configure() {
                        map().setCreateDateTime(source.getCreateDateTime());
                        map().setLastUpdateTime(source.getLastUpdateTime());
                    }
                }
        );

        modelMapper.addMappings(
                new PropertyMap<BuildingBaseDataHis, BuildingBaseDataHisDto>() {
                    protected void configure() {
                        map().setCreateDateTime(source.getCreateDateTime());
                    }
                }
        );

        modelMapper.addMappings(
                new PropertyMap<InquiryData, InquiryDataDto>() {
                    protected void configure() {
                        map().setPriceTime(source.getPriceTime());
                        map().setInquiryTime(source.getInquiryTime());
                        map().setCreateDateTime(source.getCreateDateTime());
                        map().setLastUpdateTime(source.getLastUpdateTime());
                    }
                });

        modelMapper.addMappings(
                new PropertyMap<InquiryDataHis, InquiryDataHisDto>() {
                    protected void configure() {
                        map().setPriceTime(source.getPriceTime());
                        map().setInquiryTime(source.getInquiryTime());
                        map().setCreateDateTime(source.getCreateDateTime());
                    }
                });

        modelMapper.addMappings(
                new PropertyMap<OfferCase, OfferCaseDto>() {
                    protected void configure() {
                        map().setOfferTime(source.getOfferTime());
                        map().setCreateDateTime(source.getCreateDateTime());
                        map().setLastUpdateTime(source.getLastUpdateTime());
                    }
                }
        );

        modelMapper.addMappings(
                new PropertyMap<OfferCaseHis, OfferCaseHisDto>() {
                    protected void configure() {
                        map().setOfferTime(source.getOfferTime());
                        map().setCreateDateTime(source.getCreateDateTime());
                    }
                }
        );

        modelMapper.addMappings(
                new PropertyMap<TransactionCase, TransactionCaseDto>() {
                    protected void configure() {
                        map().setPriceTime(source.getPriceTime());
                        map().setCreateDateTime(source.getCreateDateTime());
                        map().setLastUpdateTime(source.getLastUpdateTime());
                    }
                }
        );

        modelMapper.addMappings(
                new PropertyMap<TransactionCaseHis, TransactionCaseHisDto>() {
                    protected void configure() {
                        map().setPriceTime(source.getPriceTime());
                        map().setCreateDateTime(source.getCreateDateTime());
                    }
                }
        );

        modelMapper.addMappings(
                new PropertyMap<ReportCase, ReportCaseDto>() {
                    protected void configure() {
                        map().setReportTime(source.getReportTime());
                        map().setCreateDateTime(source.getCreateDateTime());
                        map().setLastUpdateTime(source.getLastUpdateTime());
                    }
                }
        );

        modelMapper.addMappings(
                new PropertyMap<ReportCaseHis, ReportCaseHisDto>() {
                    protected void configure() {
                        map().setReportTime(source.getReportTime());
                        map().setCreateDateTime(source.getCreateDateTime());
                    }
                }
        );

        modelMapper.addMappings(
                new PropertyMap<CommunityBaseData, CommunityBaseDataDto>() {
                    protected void configure() {
                        map().setCreateDateTime(source.getCreateDateTime());
                        map().setLastUpdateTime(source.getLastUpdateTime());
                    }
                }
        );

        modelMapper.addMappings(
                new PropertyMap<CommunityBaseDataHis, CommunityBaseDataHisDto>() {
                    protected void configure() {
                        map().setCreateDateTime(source.getCreateDateTime());
                    }
                }
        );

        modelMapper.addMappings(
                new PropertyMap<HouseBaseData, HouseBaseDataDto>() {
                    protected void configure() {
                        map().setCreateDateTime(source.getCreateDateTime());
                        map().setLastUpdateTime(source.getLastUpdateTime());
                    }
                }
        );

        modelMapper.addMappings(
                new PropertyMap<HouseBaseDataHis, HouseBaseDataHisDto>() {
                    protected void configure() {
                        map().setCreateDateTime(source.getCreateDateTime());
                    }
                }
        );

        modelMapper.addMappings(
                new PropertyMap<UnitBaseData, UnitBaseDataDto>() {
                    protected void configure() {
                        map().setCreateDateTime(source.getCreateDateTime());
                        map().setLastUpdateTime(source.getLastUpdateTime());
                    }
                }
        );

        modelMapper.addMappings(
                new PropertyMap<UnitBaseDataHis, UnitBaseDataHisDto>() {
                    protected void configure() {
                        map().setCreateDateTime(source.getCreateDateTime());
                    }
                }
        );
    }

    /**
     * 实体转DTO,使用Copy方式
     *
     * @param source          源实体
     * @param destinationType 目标实体类型
     * @param <T>
     * @return
     */
    public static <T> T map(Object source, Class<T> destinationType) {
        return modelMapper.map(source, destinationType);
    }

    /**
     * DTO实体转DTO
     *
     * @param source          源实体
     * @param  sourceType 源数据类型
     * @param targetType 目标实体类型
     * @param <T>
     * @return
     */
    public static <T, E> E copy(Object source, Class<T> sourceType, Class<E> targetType) {
        E targetDto = null;
        try {
            Class<?> cls = Class.forName(sourceType.getName());
            T sourceDto = (T) cls.newInstance();
            cls = Class.forName(targetType.getName());
            targetDto = (E) cls.newInstance();
            BeanCopier beanCopier = BeanCopier.create(sourceDto.getClass(), targetDto.getClass(), false);
            beanCopier.copy(source, targetDto, null);
            return targetDto;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return targetDto;
    }
}
