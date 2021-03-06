# REFACTORING
#### 나쁜 디자인의 코드를 좋은 디자인으로 바꾸는 방법 
###### 마틴 파울러 지음

## 목차
### 1. 리팩토링, 첫번째 예제
  #### 시작
  
  리팩토링의 첫 번째 단계
  - 리팩토링을 작하기 전에 견고한 테스트 세트를 가지고 있는지 확인하라. 이 테스트는 자체 검사여야 한다.
  - 리팩토링 할 부분의 코드에 대한 견고한 테스트 세트(test set)를 만드는 것이다. 
    - 버그를 유발할 수 있는 모든 상활을 피하도록 잘 만들어진 리팩토링 방법을 따른다 하더라도, 여전히 사람이 하는 일이므로 실수가 있을 수 있기 때문이다. 따라서 견고한 테스트가 필요하다.
    
  메소드의 분해 및 재분배
   - 긴 메소드를 볼 때, 메소드를 작은 조각으로 분해하는 것을 생각한다. 
     - 작은 조각의 코드는 관리하기가 쉽다. 그것들은 다루기가 쉽고, 옮기기도 쉽다.
   - 어떻게 긴 메소드를 쪼개서 적적한 클래소로 옮기는가를 보이는 것이다.
     - 중복을 최소화하면서 메소드를 만들기 쉽도록 하는 것.
     - how? 먼저 논리적으로 연관이 잇는 코드 덩어리를 찾아내고 Extract Method(136)을 사용한다.
       - 메소드를 추출할 때도 무엇이 잘못될 수 있는지를 알고 있어야 한다. 메소드를 잘못 추출하게 되면 버그를 유발할 수 있다.
       - 따라서 리팩토링을 하기 전에 어떻게 하면 안전하게 작업할 수 있을지를 생각해야 한다.
         - how? 먼저 메소드 내의 지여변수와 파라미터를 주의 깊게 볼 필요가 있다.
           - 값이 수정되지 않는 변수는 파라미터로 넘길 수 있다.
           - 값이 수정되는 변수는 주의가 필요하다.
             - 이런 변수가 하나라면 리턴을 해줄 수 있다.
              
