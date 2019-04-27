package com.snack.web;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.snack.model.Orderdetail;
import com.snack.model.Receiptinfo;
import com.snack.model.domain.DoAdminOrder;
import com.snack.model.domain.DoExcelOrder;
import com.snack.service.adminOrderService;
import com.snack.service.userService;
import com.snack.utils.DataTables;
import com.snack.utils.PageHelp;
import com.snack.utils.ResponseUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/order/")
public class AdminOrderControll {

    @Autowired
    private adminOrderService adminOrderService;

    @Autowired
    private userService userService;


    @RequestMapping("mainToAdminOrder")
    public String mainToAdminOrder() {
        return "admin/order/adminOrder";
    }

    //订单
    @RequestMapping("adminOrderLimit")
    @ResponseBody
    public DataTables adminOrderLimit(int start, int length,
                                      String oId, String oTimeStart, String oTimeEnd, String adUserName) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("pageStart", start);
        map.put("pageSize", length);
        map.put("oId", oId);
        map.put("oTimeStart", oTimeStart);
        map.put("oTimeEnd", oTimeEnd);
        map.put("adUserName", adUserName);
        PageHelp<DoAdminOrder> pageHelp = adminOrderService.selectAdminOrderLimit(map);
        DataTables datatable = new DataTables();
        datatable.setData(pageHelp.getList());
        datatable.setRecordsFiltered(pageHelp.getRecord());
        datatable.setRecordsTotal(pageHelp.getRecord());
        return datatable;
    }

    //删除订单
    @RequestMapping("deleteAdminOrder")
    @ResponseBody
    public String deleteAdminOrder(String oId) {
        return ResponseUtil.successToClient(adminOrderService.deleteAdminOrder(oId));
    }

    //update加载订单
    @RequestMapping("updateSelectAdminOrder")
    @ResponseBody
    public String updateSelectAdminOrder(int rId) {
        return ResponseUtil.successToClient(adminOrderService.updateSelectAdminOrder(rId));
    }

    //update订单
    @RequestMapping("updateAdminOrder")
    @ResponseBody
    public String updateAdminOrder(Receiptinfo receiptinfo) {
        return ResponseUtil.successToClient(adminOrderService.updateAdminOrder(receiptinfo));
    }

    //updateOrderDetial加载订单
    @RequestMapping("updateSelectAdminOrderDetial")
    @ResponseBody
    public String updateSelectAdminOrderDetial(int dId) {
        return ResponseUtil.successToClient(adminOrderService.updateSelectAdminOrderDetial(dId));
    }

    //updateOrderDetial订单
    @RequestMapping("updateOrderdetail")
    @ResponseBody
    public String updateOrderdetail(Orderdetail orderdetail) {
        return ResponseUtil.successToClient(adminOrderService.updateOrderdetail(orderdetail));
    }

    //删除OrderDetial
    @RequestMapping("deleteOrderdetail")
    @ResponseBody
    public String deleteOrderdetail(int dId, String oId) {
        List<Orderdetail> orderdetailList = adminOrderService.selectOrderdetailByoId(oId);
        if (orderdetailList.size() >= 2) {
            adminOrderService.deleteOrderdetailBydId(dId);
            return ResponseUtil.successToClient(1);
        } else {
            adminOrderService.deleteAdminOrder(oId);
            return ResponseUtil.successToClient(2);
        }
    }



    //导出订单详情
    @RequestMapping("outExcelOrder")
    public void exportXls(HttpServletResponse response) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        List<DoExcelOrder> doExcelOrders = adminOrderService.outExcelOrderDetail();
        System.out.println(doExcelOrders);
        /*for (Album album : list) {
            album.setImgPath("D:\\cmfz_ssz\\cmfz_ssz\\src\\main\\webapp\\jsp\\images\\audioCollection\\" + album.getImgPath());
        }*/
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("ssls", "ddxq"), DoExcelOrder.class, doExcelOrders);
        String oldName = "easypoi_ssls_orderDetail.xlsx";
        String encode = null;
        try {
            encode = URLEncoder.encode(oldName, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //设置响应头
        response.setHeader("content-Type", "application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;fileName=" + encode);
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            //直接将写入到输出流中即可;
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public void outExcelOrder(HttpServletResponse response, String oId) {
        SXSSFWorkbook workbook = new SXSSFWorkbook();
        reportSheet(workbook, oId);
        outputExcel(response, workbook, "订单详情");
    }

    private void reportSheet(SXSSFWorkbook workbook, String oId) {
        List<DoExcelOrder> outExcelOrderDetail = adminOrderService.outExcelOrderDetail(oId);
        for (int i = 0; i < outExcelOrderDetail.size(); i++) {
            if (i != 0) {
                outExcelOrderDetail.get(i).setOId("");
                outExcelOrderDetail.get(i).setOName("");
                outExcelOrderDetail.get(i).setOPhone("");
                outExcelOrderDetail.get(i).setOAddress("");
            }
            outExcelOrderDetail.get(i).setMoney(outExcelOrderDetail.get(i).getMoney() + "元");
        }
        ExcelUtil2 excelUtil = new ExcelUtil2();

        List<JSONObject> columns = new ArrayList<>();
        columns.add(excelUtil.defaultGetColumn("订单号", "oId", 15 * 256, false, false));
        columns.add(excelUtil.defaultGetColumn("收货人", "oName", 15 * 256, false, false));
        columns.add(excelUtil.defaultGetColumn("电话", "oPhone", 15 * 256, false, false));
        columns.add(excelUtil.defaultGetColumn("地址", "oAddress", 26 * 256, false, false));
        columns.add(excelUtil.defaultGetColumn("商品名", "sName", 15 * 256, false, false));
        columns.add(excelUtil.defaultGetColumn("数量", "num", 12 * 256, false, false));
        columns.add(excelUtil.defaultGetColumn("单价", "money", 12 * 256, false, false));

        excelUtil.createSheet(workbook, outExcelOrderDetail, columns, "订单详情");
    }

    private void outputExcel(HttpServletResponse response, SXSSFWorkbook workbook, String excelName) {
        response.setContentType("application/vnd.ms-excel");
        try {
            // 进行转码，使其支持中文文件名
            response.setHeader("content-disposition", "attachment;filename=" + new String(excelName.getBytes("GB2312"), "ISO-8859-1") + ".xlsx");
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/
    //请确认收货
    @RequestMapping("userOrderConfirm")
    @ResponseBody
    public String userOrderConfirm(HttpServletRequest request, int id, int typeNum) {
        int eId;
        if (typeNum == 0) {
            eId = (int) request.getSession().getAttribute("adminId");
        } else {
            eId = 0;
        }
        return ResponseUtil.successToClient(userService.upDateByorderConfirm(id, typeNum, eId));
    }

}
