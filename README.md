# selenium-project-3

**팀장**: 조윤호  
**팀원**: 김서현 김강민

## 프로젝트 개요
Selenium과 Java Maven을 활용하여 Accuweather 사이트에서 검색하는 도시의 주간 일자별 날씨와 강수량 데이터를 실시간으로 가져오는 프로그램을 개발하였습니다. 이를 통해 우산을 챙겨야 하는 날들을 커스텀 해보았습니다.

## 프로젝트 구조
```plaintext
selenium_practice
│
├── .settings/
├── src/
│   └── selenium_practice/
│       └── SeleniumPjt.java
├── .classpath
├── .gitignore
├── .project
├── chromedriver.exe
├── pom.xml
└── README.md
```

## 맡은 역할
- **조윤호 (팀장)**: 프로젝트 총괄 관리, Selenium 설정 및 웹 스크래핑 로직 구현
- **김서현**: 프로젝트 진행 피드백 및 다과 준비
- **김강민**: 프로젝트 문서화

## 주요 기능
1. **웹 스크래핑**: Selenium을 사용하여 Accuweather 사이트에서 주간 일자별 날씨와 강수량 데이터를 스크래핑
2. **데이터 저장**: 스크래핑한 데이터를 List로 변환하여 저장
3. **데이터 출력**: 저장된 데이터를 콘솔로 출력

## 필요 조건
- **Java 17 이상**
- **Maven 3.6 이상**
- **Selenium WebDriver**
- **ChromeDriver** (또는 다른 브라우저 드라이버)

## 사용 예시
스크래핑된 데이터를 출력하는 예제:
```java
 public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        
        driver.get("https://www.accuweather.com/ko/kr/south-korea-weather");
        
        WebElement searchInput = driver.findElement(By.cssSelector("div.featured-search-bar.featured-search > div.searchbar-content > form > input"));
        Scanner sc = new Scanner(System.in);
        System.out.printf("Please Enter Location Name: ");
        String word = sc.nextLine();
        searchInput.sendKeys(word);
        searchInput.sendKeys(Keys.ENTER);
        sc.close();
```

## Contact
- [조윤호](mailto:josephcyh@yonsei.ac.kr)
- [김서현](mailto:kgwp2017@gmail.com)
- [김강민](mailto:lnewgatel@gmail.com)
