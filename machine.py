drink_list = [
    [],
    [[],['스프라이트', 1500], ['코카콜라', 1300], ['솔의눈', 1000], ['펩시 콜라', 1100]],
    [[],['TOP커피', 1800], ['꿀물', 1500], ['홍삼차', 1700], ['단팥죽', 21]]
    ]

def select_drink_type() -> int:
        drink_type_message = '''
------------------------------
음료를 선택해 주세요!
[1] 차가운 음료
[2] 따뜻한 음료
        
        '''
        print(drink_type_message)
        type = int(input(input_message))
        return type
    
def select_item(type: int) -> int:
    cold_drinks_menu = """
------------------------------
[차가운 음료]

[1] 스프라이트 : 1,500원
[2] 코카콜라 : 1,300원
[3] 솔의눈 : 1,000원
[4] 펩시 콜라 : 1,100원
    
    """
    hot_drinks_menu = """
------------------------------
[따뜻한 음료]

[1] TOP커피 : 1,800원
[2] 꿀물 : 1,500원
[3] 홍삼차 : 1,700
[4] 단팥죽 :2,100원
    
    """
    if type == 1:
        print(cold_drinks_menu)
    elif type == 2:
        print(hot_drinks_menu)
    else:
        print("다시 입력해주세요.")
    item = int(input(input_message))
    return item

def price(type, item):
    price = drink_list[type][item][1]
    return price

# 현금 결제
def cash(money: int):
    cash_select_message = '''
[1] 5만원권 
[2] 1만원권 
[3] 5천원권  
[4] 1천원권  
[5] 500원 동전
[6] 100원 동전
[0] 반환
    '''
    cash_list = [[], 50000, 10000, 5000, 1000, 500, 100]
    sum = 0
    while (sum >= cash):
        print(f"[현금 투입 :{sum}원]")
        print(cash_select_message)
        sum += cash_list(int(input(input_message)))
    return sum

def print_result_card(type, item):  
    print('------------------------------')
    print('이용해주셔서 감사합니다.')
    print(f'[주문 음료]\n{drink_list[type][item][0]}')
    print(f'[주문 금액]\n{drink_list[type][item][1]}')

def print_result_cash(type, item, input_cash):
    print('------------------------------')
    print('이용해주셔서 감사합니다.')
    print(f'[주문 음료]\n{drink_list[type][item][0]}')
    print(f'[투입 금액]\n{input_cash}')
    
def payment(price: int, type:int, item: int):
    payment_type = '''
    ------------------------------
    [결제방식 선택]
    
    [1] 현금
    [2] 카드 (부가세 10% 적용)
    
    '''
    
    pay_type = int(input(input_message))
    if pay_type == 1:
        total = price
        change = cash(total) - total
        print_result_cash(type, item, cash(total))
    
        print(change)
        
    else:
        total = price * 1.1
        print_result_card(type, item)
    return total, pay_type


if __name__ == "__main__":
    input_message = "사용자 입력 > "
    print("[어서와요! GDSC 음료 자판기]")
    print("계속 하려면 아무 키나 입력하세요 ...")
    input("사용자 입력 > ")
    drink_type = select_drink_type()
    item = select_item(drink_type)
    money = price(drink_type, item)
    print(drink_type, item, money)
    
    
        
            
        
        
   
    