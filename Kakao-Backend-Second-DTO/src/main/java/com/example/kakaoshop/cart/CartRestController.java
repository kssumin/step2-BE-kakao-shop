package com.example.kakaoshop.cart;

import com.example.kakaoshop._core.utils.ApiUtils;
import com.example.kakaoshop.cart.request.CartSaveRequest;
import com.example.kakaoshop.cart.request.CartUpdateRequest;
import com.example.kakaoshop.cart.response.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CartRestController {

    @GetMapping("/carts")
    public ResponseEntity<ApiUtils.ApiResult<CartFindAllResponse>> findAll() {

        ArrayList<CartSingleOptionResponse> cartOptionsBySingleProduct = new ArrayList<>();

        CartOptionInfoResponse optionInfo = CartOptionInfoResponse.builder()
                .id(1)
                .optionName("01. 슬라이딩 지퍼백 크리스마스에디션 4종")
                .price(10000)
                .build();

        // 카트 아이템 리스트에 담기
        CartSingleOptionResponse cartSingleOptionBySingleProduct = CartSingleOptionResponse.builder()
                .id(4)
                .option(optionInfo)
                .quantity(5)
                .price(50000)
                .build();

        cartOptionsBySingleProduct.add(cartSingleOptionBySingleProduct);

        CartOptionInfoResponse optionInfo2 = CartOptionInfoResponse.builder()
                .id(1)
                .optionName("02. 슬라이딩 지퍼백 크리스마스에디션 5종")
                .price(10900)
                .build();

        CartSingleOptionResponse cartItemDTO2 = CartSingleOptionResponse.builder()
                .id(5)
                .option(optionInfo2)
                .quantity(5)
                .price(54500)
                .build();

        cartOptionsBySingleProduct.add(cartItemDTO2);

        // productDTO 리스트 만들기
        List<CartSingleProductItemResponse> cartProducts = new ArrayList<>();

        // productDTO 리스트에 담기
        cartProducts.add(
                CartSingleProductItemResponse.builder()
                        .id(1)
                        .productName("기본에 슬라이딩 지퍼백 크리스마스/플라워에디션 에디션 외 주방용품 특가전")
                        .cartItems(cartOptionsBySingleProduct)
                        .build()
        );

        CartFindAllResponse responseDTO = new CartFindAllResponse(cartProducts, 104500);

        return ResponseEntity.ok(ApiUtils.success(responseDTO));
    }
}
