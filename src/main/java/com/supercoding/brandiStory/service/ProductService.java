package com.supercoding.brandiStory.service;

import com.supercoding.brandiStory.repository.Entity.ProductEntity;
import com.supercoding.brandiStory.repository.products.ProductJpaRepository;
import com.supercoding.brandiStory.service.mapper.ProductMapper;
import com.supercoding.brandiStory.web.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class ProductService {
    private final ProductJpaRepository productJpaRepository;

    public List<ProductDTO> getAllProducts() {
        List<ProductEntity> productEntities = productJpaRepository.findAll();
        if (productEntities.isEmpty()) throw new NotFoundException("등록된 상품이 없습니다.");
        //     return productEntities.stream().map(ProductMapper.INSTANCE::productEntityToProductDTO).collect(Collectors.toList());
        //품절이면 제외하는 코드
        return productEntities.stream().filter(productEntity -> productEntity.getQuantity() > 0)
                .map(ProductMapper.INSTANCE::productEntityToProductDTO).collect(Collectors.toList());
    }

//쇼핑몰 전체 물품 조회 시 Pagination 사용 권장. 재고 없는 물품은 보이지 않아야함.
// Pagination 적용. http://localhost:8080/api/items-page?size=4&page=0 하고 send
//한페이지에 4개 들어갈지 8개 들어갈지 정하면 됨. 그리고 첫번째 페이지는0페이지?로 강의에서 배움
// 프론트 어떻게 구현되는지는 안해봐서 프론트에 구현되는 것 보고 1로 설정할지 2로 설정할지 정해보기.

    public Page<ProductDTO> getAllWithPageable(Pageable pageable) {
        Page<ProductEntity> productEntities = productJpaRepository.findAll(pageable);
       // ProductEntity productEntity;
        //exception넣기 if문으로 .. !
        return productEntities.stream()
                .filter(productEntity -> productEntity.getQuantity() > 0)
                .map(productEntity -> ProductMapper.INSTANCE.productEntityToProductDTO(productEntity))
               .filter(productEntities::nonNull)
                .collect(Collectors.toList());



       // return productEntities.map(ProductMapper.INSTANCE::productEntityToProductDTO);
        //품절인지 확인하는 코드 추가 //수정해야함.
//        return productEntities
//                .map(productEntity -> {
//                    if(productEntity.getQuantity()>0){
//                        return ProductMapper.INSTANCE::productEntityToProductDTO(productEntity);
//                    } else {
//                        return null;
//                    }
//                }).filter(productDTO -> productDTO !=null);
    }
}
