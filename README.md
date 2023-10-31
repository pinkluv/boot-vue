# boot-vue

 public static void main(String[] args) {
        // 더미 데이터를 추가할 리스트 생성
        List<TestVo> dataList = new ArrayList<>();

        // TestVo 객체 생성
        TestVo vo1 = new TestVo();
        vo1.setName("John");
        vo1.setEmail("john@example.com");

        TestVo vo2 = new TestVo();
        vo2.setName("Alice");
        vo2.setEmail("alice@example.com");

        // 리스트에 추가
        dataList.add(vo1);
        dataList.add(vo2);

        // 리스트의 내용 출력 (테스트용)
        for (TestVo item : dataList) {
            System.out.println("Name: " + item.getName() + ", Email: " + item.getEmail());
        }


         public static void main(String[] args) {
        // 더미 데이터를 추가할 리스트 생성
        List<TestVo> dataList = new ArrayList<>();

        // for 루프를 사용하여 여러 개의 TestVo 객체 생성 및 리스트에 추가
        for (int i = 0; i < 5; i++) {
            TestVo vo = new TestVo();
            vo.setName("Name" + i);
            vo.setEmail("email" + i + "@example.com");
            dataList.add(vo);
        }


        // 페이징 처리
        int pageSize = 5; // 페이지 크기
        int pageNo = 2;   // 표시할 페이지 번호

        int startIndex = (pageNo - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, dataList.size());

        // 리스트의 내용 출력 (페이징 처리된 부분만 출력)
        for (int i = startIndex; i < endIndex; i++) {
            TestVo item = dataList.get(i);
            System.out.println("Name: " + item.getName() + ", Email: " + item.getEmail());
        }

        // 리스트의 내용 출력 (테스트용)
        for (TestVo item : dataList) {
            System.out.println("Name: " + item.getName() + ", Email: " + item.getEmail());
        }
    }
