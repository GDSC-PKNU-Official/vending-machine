ice_beverage_type = ["스프라이트", "코카콜라", "솔의눈", "펩시 콜라"]
ice_beverage_price = [1500, 1300, 1000, 1100]
hot_beverage_type = ["TOP커피", "꿀물", "홍삼차", "단팥죽"]
hot_beverage_price = [1800, 1500, 1700, 2100]

cash_type = [50000, 10000, 5000, 1000, 500, 100]
change_count = [0,0,0,0,0,0]

chosen_beverage_type = 0   # 고객이 선택한 음료
to_pay_money = 0   # 고객이 지불해야할 금액
paid_money = 0     # 고객이 지불한 금액

# 차가운 음료 선택
def choose_ice_beverage():
    print("---------------------------")
    print("[차가운 음료]\n")
    for i in range(4):
        print("[",i+1,"] ",ice_beverage_type[i],":", ice_beverage_price[i],"원")
    chosen_beverage_type = int(input("\n사용자 입력 > "))
    to_pay_money = ice_beverage_price[chosen_beverage_type-1]
    return chosen_beverage_type, to_pay_money   # 고른 음료 번호, 결제할 금액 반환

# 뜨거운 음료 선택
def choose_hot_beverage():
    print("---------------------------")
    print("[뜨거운 음료]\n")
    for i in range(4):
        print("[",i+1,"]",hot_beverage_type[i],":",hot_beverage_price[i],"원")
    chosen_beverage_type = int(input("\n사용자 입력 > "))
    to_pay_money = hot_beverage_price[chosen_beverage_type-1]
    return chosen_beverage_type, to_pay_money    # 고른 음료 번호, 결제할 금액 반환

# 현금 투입 출력
def print_cash(paid_money):
    print("[현금 투입] : ", paid_money,"원\n")
    print("[1] 5만원권")
    print("[2] 1만원권")
    print("[3] 5천원권")
    print("[4] 1천원권")
    print("[5] 500원")
    print("[6] 100원")
    print("[0] 반환\n")

# 잔돈 계산
def calculate_changes(paid_money):
    change = paid_money - to_pay_money
    for i in range(len(cash_type)):
        change_count[i] += change // cash_type[i]
        change %= cash_type[i]
    return change_count

# 현금 결제
def pay_in_cash(paid_money,to_pay_money):
    while(paid_money < to_pay_money):
        print_cash(paid_money)
        chosen_cash_type = int(input("사용자 입력 > "))
        if chosen_cash_type != 0:
            paid_money += cash_type[chosen_cash_type-1]
        else:
            paid_money = 0
    changes = calculate_changes(paid_money)
    print("---------------------------")
    print("이용해주셔서 감사합니다.\n")
    print("[주문 음료]")
    if ice_or_hot == 1: 
        print(ice_beverage_type[chosen_beverage_type-1], "\n")
    elif ice_or_hot == 2:
        print(hot_beverage_type[chosen_beverage_type-1], "\n")
    print("[투입 금액]")
    print(paid_money)
    print("\n[잔돈]")
    for i in range(len(changes)):
        if changes[i] != 0:
            print(cash_type[i], ":", changes[i],"개")


# 카드 결제
def pay_by_card(to_pay_money):
    print("---------------------------")
    print("이용해주셔서 감사합니다.\n")
    print("[주문 음료]")
    if ice_or_hot == 1: 
        print(ice_beverage_type[chosen_beverage_type-1], "\n")
    elif ice_or_hot == 2:
        print(hot_beverage_type[chosen_beverage_type-1], "\n")
    print("[결제 금액]")
    print(int(to_pay_money+to_pay_money*0.1),"원")


print("[어서와요 ! GDSC 음료 자판기]")
print("---------------------------")
print("음료를 선택해주세요!\n")
print("[1] 차가운 음료")
print("[2] 따뜻한 음료\n")
ice_or_hot = int(input("사용자 입력 > "))
if ice_or_hot == 1:
    chosen_beverage_type, to_pay_money = choose_ice_beverage()
elif ice_or_hot == 2:
    chosen_beverage_type, to_pay_money = choose_hot_beverage()
else:
    print("유효하지 않은 입력입니다.")

print("---------------------------")
print("[결제 방식 선택]\n")
print("[1] 현금")
print("[2] 카드 (부가세 10% 적용)\n")
cash_or_card = int(input("사용자 입력 > "))
if cash_or_card == 1:
    pay_in_cash(paid_money,to_pay_money)
elif cash_or_card == 2:
    pay_by_card(to_pay_money)
else:
    print("유효하지 않은 입력입니다.")