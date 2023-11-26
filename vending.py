import math

# 주문 함수
def order_drink():
    global menu

    print("음료를 선택 해주세요!\n[1] 차가운 음료\n[2] 따뜻한 음료")
    menu_type = int(input("사용자 입력 > "))
    print("-------------------------------")
    if menu_type == 1:
        print("[차가운 음료]")
        menu = menu["차가운 음료"]
    elif menu_type == 2:
        print("[따듯한 음료]")
        menu = menu["따듯한 음료"]
    else:
        print("잘못된 메뉴 유형입니다.")
        return None, 0
    
    selected_drink, selected_price = select_menu()

    return selected_drink, selected_price

# 메뉴 보여주기 및 선택 함수
def select_menu():
    for i, (drink, price) in enumerate(menu.items(), start=1):
        print(f"[{i}] {drink} : {price}원")

    user_choice = int(input("사용자 입력 > "))
    selected_drink = list(menu.keys())[user_choice - 1]
    selected_price = menu[selected_drink]
    
    return selected_drink, selected_price

# 결제 방식 선택 
def payment_task(selected_drink, selected_price):
    print("[결제 방식 선택]")
    print("[1] 현금\n[2] 카드 (부가세 10% 적용)")
    payment_method = int(input("사용자 입력 > "))
    if payment_method == 1 :
        cash_pay(selected_drink, selected_price)
    if payment_method == 2 :
        selected_price += selected_price / 10
        print(f"-------------------------------\ns이용해주셔서 감사합니다. \n\n[주문 음료]\n{selected_drink}\n\n[결제 금액]\n{math.trunc(selected_price)}원")

# 현금 결제 
def cash_pay(selected_drink, selected_price) :
    total_cash = 0
    while total_cash <= selected_price:
        print("-------------------------------")
        print(f"[현금 투입 : {total_cash}원]")
        print("[1] 5만원권\n[2] 1만원권\n[3] 5천원권\n[4] 1천원권\n[5] 500원\n[6] 100원\n[0] 반환")
        cash_input = int(input("사용자 입력 > "))

        if cash_input == 0:
           total_cash = 0

        cash_values = [50000, 10000, 5000, 1000, 500, 100, 0]
        total_cash += cash_values[cash_input - 1]

        print("-------------------------------\n이용해주셔서 감사합니다.\n")
        print(f"[주문 음료] \n{selected_drink}\n")
        print(f"[투입 금액] \n{total_cash}원\n")

        change = total_cash - selected_price
        change_units = [500, 100]
        print("[잔돈]")
        for unit in change_units:
            count = change // unit
            change %= unit
            if count > 0:
                print(f"{unit}원 동전 : {count}개")


# 매니저 부분
def manager_task():
    print("-------------------------------\n[관리자 설정]\n추가하실 메뉴를 입력해주세요!")

def main():
    global menu
    menu = {"차가운 음료" : {"코카콜라" : 1500, "스프라이트" : 1300, "솔의눈" : 1000, "제로콜라" : 1600}, "따듯한 음료" : {"코코아" : 700, "커피" : 1000}}

    # 시작
    input("[어서와요! GDSC 음료 자판기]\n 계속 하려면 아무키나 입력하세요 ...")
    print("-------------------------------\n[사용자 선택]\n[1] 사용자\n[2] 관리자\n[3] 종료")
    Task_menu = int(input("사용자 입력 > "))
    print("-------------------------------")
    if Task_menu == 1 :
        print("[사용자]")
    elif Task_menu == 2:
         print("[관리자]")
         manager_task()
    else : 
        print("잘못 입력하셨습니다!")
        return 0
        

    selected_drink, selected_price = order_drink()

    print(f"-------------------------------\n[주문 음료] {selected_drink}\n")

    payment_task(selected_drink, selected_price)

if __name__ == "__main__":
    main()
