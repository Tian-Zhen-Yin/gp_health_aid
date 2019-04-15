package com.example.yangyang.gp_health_aid.db;

import com.example.yangyang.gp_health_aid.bean.Passage;

public class MyDB {
   private static String [] passage_uri  ={
           "http://mp.weixin.qq.com/s?__biz=MzA5ODM0ODgzMA==&mid=2651222075&idx=1&sn=00d8ca84806d6710e304f646913352e9&chksm=8b602a4abc17a35c035df9ccb1d9c65ad1ae84e0e2e53bc505337a20ab22402cb5183d4b32e3&mpshare=1&scene=23&srcid=0408oEXtXf5c0V4jztEKhuJe#rd",
           "http://mp.weixin.qq.com/s?__biz=MjM5MDUwNTEyMw==&mid=2247493810&idx=1&sn=dd311f4b46589cff2866138bf01d34d7&chksm=a641697e9136e068f150c4dad88788ee528f091753c302f2b2eac8d637d618ac49fe7665dc48&mpshare=1&scene=23&srcid=0408M1ltLA0Ng00oPbDXm95Z#rd",
           "http://mp.weixin.qq.com/s?__biz=MjM5OTgyODIwMQ==&mid=2653003748&idx=1&sn=293cf27ac9d4983424d55b2659d9afbb&chksm=bce0b0628b97397407941b6c2401e408579182bbbb432ba3b02fb19cf2fef76ec777a7431892&mpshare=1&scene=23&srcid=0408VcLqG7LNhPSXTaQIAXS4#rd",
           "http://mp.weixin.qq.com/s?__biz=MzAwOTQwMTIyNg==&mid=2654649439&idx=1&sn=8f31c68375251b6893eadc307d3ee25e&chksm=80ae3abab7d9b3acccce3cd74855e5affa0a54bbc45dad9c34cbeb22ec48a068557dbe2dac22&mpshare=1&scene=23&srcid=0408evNAIoaQyvGhn01hUBOV#rd",
           "http://mp.weixin.qq.com/s?__biz=MzA5NzA1OTI3MA==&mid=2650768069&idx=3&sn=b1192ee604cde047b0a575e5290c0476&chksm=88ad8a6cbfda037a3d69ee1b4f13c6564f3c95ed3196f88b8b2946ee291b703d3601fc7fe100&mpshare=1&scene=23&srcid=04088724pUJgyjGzYz3i5SqG#rd",

           "http://mp.weixin.qq.com/s?__biz=MzI3MzYzMjkyNw==&mid=2247486535&idx=4&sn=da32ba0bdbe27ff440c231a7e240314b&chksm=eb2117b7dc569ea14c539e543fa238d5cad75289439f0af170926e77b108f5f5c23cf44d6a42&mpshare=1&scene=23&srcid=0408z2w3oLvfwj3i4vgamGx8#rd",
           "http://mp.weixin.qq.com/s?__biz=MzUxOTc5MjMwMw==&mid=2247489392&idx=3&sn=b3f1f6df650fa95852d5f4f939f0ace6&chksm=f9f564b0ce82eda635d1bd205974820fa3ace33b0c90f939d7ecddbeae7d435cf6a262ad71cd&mpshare=1&scene=23&srcid=0408SHiSwyytnssY5VJAN2dr#rd",
           "http://mp.weixin.qq.com/s?__biz=MzAwMjIwNTU2Nw==&mid=2650675319&idx=8&sn=ff80e9350bb12bc0f7a724b9aa626f18&chksm=82c74a67b5b0c37124076ac76d9358c85d9c909ebc9c24ab1dfd09a391c6e9a66eba0f9bf07f&mpshare=1&scene=23&srcid=0408rl49QjrDhNc4CBHeh97Q#rd",
           "http://mp.weixin.qq.com/s?__biz=MzA4OTM2MDcyNQ==&mid=2651571042&idx=3&sn=654b85d79cb32c72a6a50fbe4eb43903&chksm=8be37358bc94fa4ef50efb765bd5a81d48e79232d0f2aa52bcb6750d3b7c666527791f000f19&mpshare=1&scene=23&srcid=0408tbJDZNVzyVaMPKfLtoRA#rd",
           "http://mp.weixin.qq.com/s?__biz=MjM5MTQzNDEzOQ==&mid=2654965820&idx=3&sn=3ea99b71e9ffbd7946bc7a82f14e4eab&chksm=bd7ea4c88a092dde80b05aef3e420f446ddd5f6e01836f1f8788d1bc91b1faa8aea68a56a698&mpshare=1&scene=23&srcid=0408tF9crrZCdsRhxsjxaGho#rd",
    };

   private static String [] passage_title = {
           "今日清明，养生要点",
           "养生长寿“十字诀”，每个人都应该背下来！",
           "被你忽略的饭后30分钟，是专家眼中的“养生黄金期”",
           "保养后背 = 保命，比养脸更重要！",
           "什么叫养生？",

           "养生之道",
           "养生不排寒，一切都白谈！",
           "养生的最高境界，是这两个字！",
           "养生遵循“七养诀“，气足百病灭！",
           "养生要对身体“下手”，没事多做2“揉”2“搓”",



   };

   private static String [] pic_uri = {
           "https://mmbiz.qpic.cn/mmbiz_jpg/3a6Cg9e0mCiaE09QfiaqYUUaarSeChEuL76VL8w4MGD6Z5kV3ugbXteNJUG0cXPI539oiaJe8d7F1QG3IF7YmeqXA/640?wx_fmt=jpeg&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1",
           "https://mmbiz.qpic.cn/mmbiz_jpg/ibxYG4ibujp7J2VbRIy45sMDjKGLicKqeJ7ss74ic26tiamtkYIIZQK7R9Yxmo348hfkTTfMAvViaVMNCY5wBezEHibiaA/640?wx_fmt=jpeg&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1",
           "https://mmbiz.qpic.cn/mmbiz_jpg/LW6jyicrwOUNrwia2PLWHKzjaGo9iclnuIHPy01pbib1yksREOCibNQSkqrTm6xZasRXWkJH0wmV13ibs0DibJt2bIHWw/640?wx_fmt=jpeg&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1",
           "https://mmbiz.qpic.cn/mmbiz/zB8pibPh9onXDHAakoWusWw5xlKFxM5O296HXiaGtHeUH0bNjqicAfzVjFLc8QkXpsdm8NiaXsW6QukNw4iaeydYzPg/640?tp=webp&wxfrom=5&wx_lazy=1&wx_co=1",
           "https://mmbiz.qpic.cn/mmbiz_jpg/k5pSdyHkTLMx4wYkk0IJ0dTiar0QicsmezgMXKO0JmOvib2MRwzn0v0Nb9R5IanJXDzGyQG3IVkPnhpb7p6TPJPOQ/640.jpeg?tp=webp&wxfrom=5&wx_lazy=1&wx_co=1",

           "https://mmbiz.qpic.cn/mmbiz_jpg/O0s2JV2PA8ql3SovGgLrXN3d9XJkgKyrraQFCKwAIMhhZbvMPX37vh3H2XmibMIUj5gEuKLAyVAtuvPxqRuWTBw/640?wx_fmt=jpeg&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1",
           "https://mmbiz.qpic.cn/mmbiz_jpg/k6pNwecn4OA7S2CLYnuxNUpUHOLhuVAVuTicOkLXAlhzKiaXriaibVfYTSibVm1sWZicZdRvxS16OpCkweOK90jqJrlg/640?wx_fmt=jpeg&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1",
           "https://mmbiz.qpic.cn/mmbiz_jpg/Qob8NXDMuqeY0ibKbo7lzvakia0g19saGbsWTQOh0k7NSZx9QjZbVicu5Mrr4iaiaJxJucb5jabm0p4ztGBjoJNJ6yw/640?wx_fmt=jpeg&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1",
           "https://mmbiz.qpic.cn/mmbiz_jpg/xhQFvib781Iur7c48Miag51nenY0GCibTNHjPK7pWjaVudWaRgQUyDk8o3MurVln0cZvUGsLsp4Q5cT5HRk5orvVQ/640?wx_fmt=jpeg&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1",
           "https://mmbiz.qpic.cn/mmbiz_jpg/fGJBic2IGMJJIdBnTOy8znwfD1aOBPF57ZaSmJdt34pSk4zhHxbe2E5X4jHMAPz4sSTlMcVAHod2eb6S53pQKiaA/640?wx_fmt=jpeg&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1",

   };


   public static void formPassage(){
       for (int i = 0;i<passage_title.length;i++){
           Passage passage = new Passage();
           passage.setPassage_uri(passage_uri[i]);
           passage.setTitle(passage_title[i]);
           passage.setPic_uri(pic_uri[i]);
           passage.save();
       }

    }



}
