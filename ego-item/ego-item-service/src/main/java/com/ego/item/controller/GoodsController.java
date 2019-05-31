package com.ego.item.controller;

import com.ego.common.pojo.PageResult;
import com.ego.item.bo.SpuBO;
import com.ego.item.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 〈〉
 *
 * @author coach tam
 * @email 327395128@qq.com
 * @create 2019/5/31
 * @since 1.0.0
 * 〈坚持灵活 灵活坚持〉
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
//    page?key=&saleable=1&page=1&rows=5
    @GetMapping("/spu/page")
    public ResponseEntity<PageResult<SpuBO>> page(
        @RequestParam(value = "key") String key,
        @RequestParam(value = "saleable") Boolean saleable,
        @RequestParam(value = "page",defaultValue = "1") Integer page,
        @RequestParam(value = "rows",defaultValue = "5") Integer rows
    )
    {
        PageResult<SpuBO> result = goodsService.page(key, saleable, page, rows);

        if(result==null)
        {
            return  ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result);
    }


    @PostMapping
    public ResponseEntity<Void> save(@RequestBody SpuBO spuBO)
    {
        goodsService.save(spuBO);

        return ResponseEntity.ok(null);
    }
}
