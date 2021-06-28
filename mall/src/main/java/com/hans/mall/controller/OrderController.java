package com.hans.mall.controller;

import com.github.pagehelper.PageInfo;
import com.hans.mall.consts.MallConst;
import com.hans.mall.form.OrderCreateForm;
import com.hans.mall.pojo.Order;
import com.hans.mall.pojo.User;
import com.hans.mall.service.impl.OrderServiceImpl;
import com.hans.mall.vo.OrderVo;
import com.hans.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @PostMapping("/oders")
    public ResponseVo<OrderVo> create(@Valid @RequestParam OrderCreateForm form, HttpSession session) {
        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
        return orderService.create(user.getId(), form.getShippingId());
    }

    @GetMapping("/orders")
    public ResponseVo<PageInfo> list(@RequestParam Integer pageNum,
                                     @RequestParam Integer pageSize,
                                     HttpSession session) {
        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
        return orderService.list(user.getId(), pageNum, pageSize);
    }

    @GetMapping("/orders/{orderNo}")
    public ResponseVo<OrderVo> detail(@PathVariable Long orderNo,
                                      HttpSession session) {
        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
        return orderService.detail(user.getId(), orderNo);
    }

    @DeleteMapping ("/orders/{orderNo}")
    public ResponseVo<OrderVo> cancel(@PathVariable Long orderNo,
                                      HttpSession session) {
        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
        return orderService.cancel(user.getId(), orderNo);
    }


}
