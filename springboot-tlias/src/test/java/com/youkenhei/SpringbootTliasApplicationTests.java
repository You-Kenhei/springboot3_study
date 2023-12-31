package com.youkenhei;

import com.youkenhei.pojo.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

@ServletComponentScan
@SpringBootTest
@RestController
class SpringbootTliasApplicationTests {
    @Autowired
    private AliOSSUtils aliOSSUtils;

    @Test
    @PostMapping("/testLoad")
    public Result testLoad(MultipartFile image) throws IOException {
        String url = aliOSSUtils.upload(image);

        return Result.success(url);
    }

    @Test
    public void testOfShit() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int result = 0;
        boolean odd = false;
        while (true) {
            for (int num : nums) {
                if (num % 2 == 0) {
                    odd = true;
                }
                if (odd == true) {
                    break;
                }
            }
            for (int num : nums) {
                num /= 2;
            }
            result++;
        }
    }

    @Test
    public void test1(){
        Integer[] arr = {2,4,3,5,1,6};
        Arrays.sort(arr, Collections.reverseOrder());

        int n = 5;
        Integer[] arr2 = new Integer[n];
        System.out.println("%d");
    }


}
