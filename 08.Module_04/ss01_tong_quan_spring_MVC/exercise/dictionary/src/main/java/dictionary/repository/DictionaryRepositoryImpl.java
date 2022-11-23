package dictionary.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DictionaryRepositoryImpl implements IDictionaryRepository{
    private static Map<String, String> dictionaryMap;

    static {
        dictionaryMap = new HashMap<>();
        dictionaryMap.put("abandon", "bỏ, từ bỏ");
        dictionaryMap.put("abandoned", "bị bỏ rơi, bị ruồng bỏ");
        dictionaryMap.put("ability", "khả năng, năng lực");
        dictionaryMap.put("able", "có năng lực, có tài");
        dictionaryMap.put("unable", "không có năng lực, không có tài");
        dictionaryMap.put("about", "khoảng, về");
        dictionaryMap.put("above", "ở trên, lên trên");
        dictionaryMap.put("abroad", "ở, ra nước ngoài, ngoài trời\"");
        dictionaryMap.put("absence", "sự vắng mặt");
        dictionaryMap.put("absent", "vắng mặt, nghỉ");
        dictionaryMap.put("absolute", "tuyệt đối, hoàn toàn");
        dictionaryMap.put("absolutely", "tuyệt đối, hoàn toàn");
        dictionaryMap.put("absorb", "thu hút, hấp thu, lôi cuốn");
        dictionaryMap.put("abuse", "lộng hành, lạm dụng");
        dictionaryMap.put("academic", "thuộc học viện, ĐH, viện hàn lâm");
        dictionaryMap.put("accent", "trọng âm, dấu trọng âm");
        dictionaryMap.put("accept", "chấp nhận, chấp thuận");
        dictionaryMap.put("acceptable", "có thể chấp nhận, chấp thuận");
        dictionaryMap.put("access", "lối, cửa, đường vào");
        dictionaryMap.put("accident", "tai nạn, rủi ro");
        dictionaryMap.put("accidental", "tình cờ, bất ngờ");
        dictionaryMap.put("accidentally", "tình cờ, ngẫu nhiên");
        dictionaryMap.put("accommodation", "sự thích nghi, điều tiết");
        dictionaryMap.put("accompany", "đi theo, đi cùng, kèm theo");
        dictionaryMap.put("account", "tài khoản, kế toán; tính toán, tính đến");
        dictionaryMap.put("accurate", "đúng đắn, chính xác, xác đáng");
        dictionaryMap.put("accurately", "đúng đắn, chính xác");
        dictionaryMap.put("accuse", "tố cáo, buộc tội, kết tội");
        dictionaryMap.put("achieve", "đạt được, dành được");
        dictionaryMap.put("achievement", "thành tích, thành tựu");
        dictionaryMap.put("acid", "axit");
        dictionaryMap.put("acknowledge", "công nhận, thừa nhận");
        dictionaryMap.put("acquire", "dành được, đạt được, kiếm được");
        dictionaryMap.put("across", "qua, ngang qua");
        dictionaryMap.put("act", "hành động, hành vi, cử chỉ, đối xử");
        dictionaryMap.put("action", "hành động, hành vi, tác động");
        dictionaryMap.put("active", "tích cực hoạt động, nhanh nhẹn");

    }
    @Override
    public String translateE(String inputE) {

        return dictionaryMap.get(inputE);
    }
}
