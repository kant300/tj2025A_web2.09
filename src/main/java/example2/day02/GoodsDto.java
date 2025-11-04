package example2.day02;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 엔티티는 서비스에만 사용, controller를 위해 DTO사용
@Data@AllArgsConstructor@NoArgsConstructor@Builder
public class GoodsDto {
    // 데이터베이스/엔티니 필드/속성 기반으로 구성
    private int gno;
    private int gprice;
    private String crate_date;
    private String update_date;
    private String gname;
    private String gdesc;
    // ****** DTO --> ENTITY ******
    // ** Contorller -> Service **  : C(등록) U(수정)
    public GoodsEntity toEntity(){
        return GoodsEntity.builder()
                // .gno() // auto 제외
                .gno( this.gno) // 수정할때 사용됨
                .gname( this.gname )
                .gprice( this.gprice )
                .gdesc( this.gdesc )
                // .date // 자동제외
                .build();
    }

}
