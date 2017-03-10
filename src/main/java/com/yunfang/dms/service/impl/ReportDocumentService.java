package com.yunfang.dms.service.impl;

import com.yunfang.dms.dao.mapper.ReportDocumentMapper;
import com.yunfang.dms.dto.PageVo;
import com.yunfang.dms.dto.ReportCaseDto;
import com.yunfang.dms.dto.ReportDocumentDto;
import com.yunfang.dms.entity.ReportCase;
import com.yunfang.dms.entity.ReportCaseCond;
import com.yunfang.dms.entity.ReportDocument;
import com.yunfang.dms.entity.ReportDocumentCond;
import com.yunfang.dms.init.MapperConfig;
import com.yunfang.dms.service.inter.IReportDocumentService;
import com.yunfang.dms.utils.UserInfoUtil;
import com.yunfang.resourcepool.model.ResultInfo;
import com.yunfang.resourcepool.sdk.ResourcesPoolUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/2/24.
 */
@Service
public class ReportDocumentService implements IReportDocumentService {
    @Autowired
    private ReportDocumentMapper mapper;
    @Autowired
    private ReportCaseService reportCaseService;

    @Override
    public void upLoadReportFile(String dirPath, String reportNo) {
        ReportCaseCond con = new ReportCaseCond();
        con.createCriteria().andReportNoEqualTo(reportNo).andCompanyIdEqualTo(UserInfoUtil.getCurrentUserCompanyId());
        long reportCaseId = 0;
        List<ReportCaseDto> dtos = reportCaseService.selectByCond(con);
        if (dtos == null || dtos.size() < 1) {
            return;
        }
        reportCaseId = dtos.get(0).getId();
        ReportDocumentCond reportDocumentCond=new ReportDocumentCond();
        //首先删除该报告的资源
        reportDocumentCond.createCriteria().andReportCaseIdEqualTo(reportCaseId);
        delete(reportDocumentCond);
        List<File> filelist = new ArrayList<File>();
        //获取文件列表
        getFileList(dirPath, filelist);
        for (Iterator<File> item = filelist.iterator(); item.hasNext(); ) {
            File file = item.next();
            String prefix = file.getName().substring(file.getName().lastIndexOf(".") + 1);
            try {
                FileInputStream fileStream = new FileInputStream(file);
                ResultInfo<String> result = ResourcesPoolUtils.fileUploadByInputStream(file.getName(), prefix, reportCaseId + "", reportCaseId + "", "报告文件", fileStream);
                if (result.getSuccess()) {

                    Long resourceId = Long.parseLong(result.getData());
                    ReportDocument document = new ReportDocument();
                    Date now = new Date();
                    document.setCreateDateTime(now);
                    document.setName(file.getName());
                    document.setOperator(UserInfoUtil.getCurrentUser().getLoginName());
                    document.setResourceId(resourceId);
                    document.setReportCaseId(reportCaseId);
                    insert(document);
                }
            } catch (Exception ex) {
            }
        }
    }

    public boolean insert(ReportDocument entity) {
        return mapper.insert(entity) > 0;
    }

    public boolean delete(ReportDocumentCond reportDocumentCond) {
        return mapper.deleteByExample(reportDocumentCond) > 0;
    }
    /*
    * 获取目录中的文件
    * */
    public void getFileList(String strPath, List<File> filelist) {
        File dir = new File(strPath);
        File[] files = dir.listFiles(); // 该文件目录下文件全部放入数组
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getName();
                if (files[i].isDirectory()) { // 判断是文件还是文件夹
                    getFileList(files[i].getAbsolutePath(), filelist); // 获取文件绝对路径
                } else { // 判断文件名是否以.avi结尾
                    filelist.add(files[i]);
                }
            }
        }
    }

    public PageVo<ReportDocumentDto> getReports(int start, int length, int draw,long id){
        ReportDocumentCond reportDocumentCond=new ReportDocumentCond();
        reportDocumentCond.createCriteria().andReportCaseIdEqualTo(id);
        reportDocumentCond.setOrderByClause("ID DESC");
        long total = mapper.countByExample(reportDocumentCond);
        PageVo<ReportDocumentDto> pageVo = new PageVo<ReportDocumentDto>(total);
        List<ReportDocument> list=mapper.selectByExample(reportDocumentCond);
        List<ReportDocumentDto> result=new ArrayList<ReportDocumentDto>();
        for (ReportDocument data:
             list) {
            result.add(MapperConfig.map(data,ReportDocumentDto.class));
        }
        pageVo.setAaData(result);
        pageVo.setDraw(draw);
        return pageVo;
    }

    public ReportDocumentDto get(long id){
        ReportDocument entity=mapper.selectByPrimaryKey(id);
        ReportDocumentDto dto=MapperConfig.map(entity,ReportDocumentDto.class);
        return dto;
    }
}
