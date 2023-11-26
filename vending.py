def select_temperature():
    print("[어서와요! GDSC 음료 자판기]")
    input("사용자 입력 > ")
    print("------------------------------")
    print("음료를 선택 해주세요!\n")
    print("[1] 차가운 음료\n[2] 따뜻한 음료\n")
    temperature = (input("사용자 입력 > "))
    print("\n------------------------------")
    return temperature

def cold(juice_list, price_list, cold_idx):
    print("[차가운 음료]\n")
    for i in range(cold_idx):
        price = str(price_list[i])
        price =  price[:-3] + "," + price[i][-3:]
        print(f"[{i + 1}] {juice_list[i]} : {price}원")
    juice = int(input("사용자 입력 > "))
    if (juice < 1 or juice > cold_idx):
        error_handle()
    print("\n------------------------------")
    return juice_list[juice - 1], price_list[juice - 1]

def hot(juice_list, price_list, cold_idx):
    print("[차가운 음료]\n")
    for i in range(len(juice_list) - cold_idx):
        price = str(price_list[i + cold_idx])
        price =  price[:-3] + "," + price[-3:]
        print(f"[{i + 1}] {juice_list[i + cold_idx]} : {price}원")
    juice = int(input("\n사용자 입력 > "))
    print("\n------------------------------")
    return juice_list[juice + cold_idx - 1], price_list[juice + cold_idx - 1]

def select_pay():
    print("[결제 방식 선택]\n")
    print("[1] 현금")
    print("[2] 카드 (부가세 10% 적용)\n")
    payment = int(input("사용자 입력 > "))
    print("\n------------------------------")
    return payment

def cash_input(sum):
    print(f"[현금 투입 : {sum}원]\n")
    print("[1] 5만원권")
    print("[2] 1만원권")
    print("[3] 5천원권")
    print("[4] 1천원권")
    print("[5] 500원")
    print("[6] 100원")
    print("[0] 반환\n")
    num = int(input("사용자 입력 > "))
    print("\n------------------------------")
    return num

#ui와 분리..
def cash_calculate(sum, price, cash_list):
    while (sum < price):
        num = cash_input(sum)
        
        if (num == 0):
            sum = 0
        elif (num >= 1 and num <= 6):
            sum += cash_list[num - 1]
        else:
            error_handle()
    return sum

def change_calculate(change, cash_list):
    ret = []
    for cash in cash_list:
        ret.append(change // cash)
        change %= cash
    return ret

def change_print(cash_list, ret):
    print("[잔돈]\n")
    for i in range(len(cash_list)):
        if (ret[i] != 0):
            print(f"{cash_list[i]}원 동전 : {ret[i]}개\n")

def error_handle():
    print("잘못 입력하셨으므로 자판기가 종료됩니다.")
    exit

def cash_output(juice, sum, cash_list, ret):
    print("\n------------------------------")
    print("이용해주셔서 감사합니다.\n")
    print(f"[주문 음료]\n{juice}\n")

    pay = str(sum)
    pay =  pay[:-3] + "," + pay[-3:]
    print(f"[투입 금액]\n{pay}원\n")
    change_print(cash_list, ret)

def card_output(juice, price):
    print("\n------------------------------")
    print("이용해주셔서 감사합니다.\n")
    print(f"[주문 음료]\n{juice}\n")
    
    pay = str(int(price * 1.1))
    pay =  pay[:-3] + "," + pay[-3:]
    print(f"[결제 금액]\n{pay}원")


def main():
    price_list = [1500, 1300, 1000, 1100, 1800, 1500, 1700, 2100]
    juice_list = ["스프라이트", "코카콜라", "솔의눈", "펩시 콜라", "TOP커피", "꿀물", "홍삼차", "단팥죽"]
    cash_list = [50000, 10000, 5000, 1000, 500, 100]

    temperature = select_temperature()
    cold_idx = 4

    if (temperature == "1"):
        juice, price = cold(juice_list, price_list, cold_idx)
    elif (temperature == "2"):
        juice, price = hot(juice_list, price_list, cold_idx)
    else:
        error_handle()

    payment = select_pay()

    if (payment == 1):
        sum = cash_calculate(0, price, cash_list)
        print(price)
        ret = change_calculate(sum - price, cash_list)
        cash_output(juice, sum, cash_list, ret)
    elif (payment == 2):
        card_output(juice, price)
    else:
        error_handle()

main()
