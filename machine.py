beverage_list = [
    [],
    [[],['스프라이트', 1500], ['코카콜라', 1300], ['솔의눈', 1000], ['펩시 콜라', 1100]],
    [[],['TOP커피', 1800], ['꿀물', 1500], ['홍삼차', 1700], ['단팥죽', 21]]
    ]
denomination = [[], 50000, 10000, 5000, 1000, 500, 100]
input_message = "사용자 입력 > "

# 음료 타입 지정
def select_beverage_type() -> int:
        print('''
------------------------------
음료를 선택해 주세요!
[1] 차가운 음료
[2] 따뜻한 음료
        
        ''')
        type = int(input(input_message))
        return type

# 지정된 타입에 해당하는 음료 선택  
def select_item(type: int) -> int:
    if type == 1:
        print("""
------------------------------
[차가운 음료]

[1] 스프라이트 : 1,500원
[2] 코카콜라 : 1,300원
[3] 솔의눈 : 1,000원
[4] 펩시 콜라 : 1,100원
    
    """)
    elif type == 2:
        print("""
------------------------------
[따뜻한 음료]

[1] TOP커피 : 1,800원
[2] 꿀물 : 1,500원
[3] 홍삼차 : 1,700원
[4] 단팥죽 :2,100원
    
    """)
    else:
        print("다시 입력해주세요.")
    item = int(input(input_message))
    return item

# 음료 가격
def show_beverage_price(type, item):
    beverage_price = beverage_list[type][item][1]
    return beverage_price

# 결제 수단 선택   
def payment_method() -> int:
    print('''
------------------------------
[결제방식 선택]

[1] 현금
[2] 카드 (부가세 10% 적용)
    
    ''')
    payment_type = int(input(input_message))
    return payment_type

# 현금 결제
# 현금 결제 - 자판기 현금 삽입
def insert_cash(money: int) -> int: 
    sum = 0
    while (sum < money):
        print(f"[현금 투입 :{sum}원]")
        print('''
[1] 5만원권 
[2] 1만원권 
[3] 5천원권  
[4] 1천원권  
[5] 500원 동전
[6] 100원 동전
[0] 반환
    ''')
        denomination_idx = int(input(input_message))
        sum += denomination[denomination_idx]
    return sum

# 현금 결제 - 거스름돈 계산
def calculate_change(price: int, insert_cash_sum: int) -> list:
    change = insert_cash_sum - price
    # print(f'insert_cash_sum: {insert_cash_sum}, price: {price}, change: {change}')
    change_list = [0,]
    for i in range(1, len(denomination)):
        answer = change // denomination[i]
        change %= denomination[i]
        change_list.append(answer)
    # print(change_list)
    return change_list

# 현금 결제 - 출력
def caculate_cash(beverage_price: int, insert_cash: int, type: int, item: int) -> None:
    change_list = calculate_change(beverage_price, insert_cash)
    # print(change_list)
    print('------------------------------')
    print('이용해주셔서 감사합니다.')
    print(f'[주문 음료]\n{beverage_list[type][item][0]}\n')
    print(f'[투입 금액]\n{insert_cash}\n')
    if sum(change_list) != 0:
        print('[잔돈]')
        for i in range(1, len(change_list)):
            if change_list[i] == 0: continue
            print(f'{denomination[i]}원 : {change_list[i]}개')
        
# 카드 결제
def calculate_card(type: int, item: int):  
    print('------------------------------')
    print('이용해주셔서 감사합니다.')
    print(f'[주문 음료]\n{beverage_list[type][item][0]}')
    print(f'[주문 금액]\n{round(beverage_list[type][item][1] * 1.1)}')

def hello():
    print('''
[어서와요! GDSC 음료 자판기]
계속 하려면 아무 키나 입력하세요 ...  
    ''')
    input("사용자 입력 > ")
    

if __name__ == "__main__":
    hello()
    beverage_type = select_beverage_type()
    item = select_item(beverage_type)
    beverage_price = show_beverage_price(beverage_type, item)
    payment_type = payment_method()
    if payment_type == 1:
        input_cash = insert_cash(beverage_price)
        print(f'input_cash:{input_cash}')
        print(input_cash)
        caculate_cash(beverage_price, input_cash, beverage_type, item)
    
    calculate_card(beverage_type, item)
    
    
        
            
        
        
   
    