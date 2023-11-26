def select_temperature():
    print("[어서와요! GDSC 음료 자판기]")
    input("사용자 입력 > ")
    print("------------------------------")
    print("음료를 선택 해주세요!\n")
    print("[1] 차가운 음료\n[2] 따뜻한 음료\n")
    temperature = (input("사용자 입력 > "))
    print("\n------------------------------")
    return temperature

def cold(juice_list, price_list):
    print("[차가운 음료]\n")
    print("[1] 스프라이트 : 1,500원")
    print("[2] 코카콜라 : 1,300원")
    print("[3] 솔의눈 : 1,000원")
    print("[4] 펩시 콜라 : 1,100원\n")
    juice = int(input("사용자 입력 > "))
    if (juice < 1 or juice > 4):
        print("잘못 입력하셨으므로 자판기가 종료됩니다.")
        exit
    print("\n------------------------------")
    return juice_list[juice - 1], price_list[juice - 1]

def hot(juice_list, price_list):
    print("[차가운 음료]\n")
    print("[1] TOP커피 : 1,800원")
    print("[2] 꿀물 : 1,500원")
    print("[3] 홍삼차 : 1,700원")
    print("[4] 단팥죽 :2,100원\n")
    juice = int(input("사용자 입력 > "))
    print("\n------------------------------")
    return juice_list[juice + 3], price_list[juice + 3]

def add_juice():
    print("[관리자 페이지 - 음료 관리]\n")

def select_pay():
    print("[결제 방식 선택]\n")
    print("[1] 현금")
    print("[2] 카드 (부가세 10% 적용)\n")
    payment = int(input("사용자 입력 > "))
    print("\n------------------------------")
    return payment

def cash(sum, price, cash_list):
    while(sum < price):
        print("[현금 투입 : {}원]\n".format(sum))
        print("[1] 5만원권")
        print("[2] 1만원권")
        print("[3] 5천원권")
        print("[4] 1천원권")
        print("[5] 500원")
        print("[6] 100원")
        print("[0] 반환\n")
        num = int(input("사용자 입력 > "))
        print("\n------------------------------")
        
        if (num == 0):
            sum = 0
        elif (num >= 1 and num <= 6):
            sum += cash_list[num - 1]
        else:
            print("잘못 입력하셨으므로 자판기가 종료됩니다.")
            exit
    return sum

def cal(change, cash_list):
    ret = []
    for cash in cash_list:
        ret.append(change // cash)
        change %= cash
    return ret

def main():
    price_list = [1500, 1300, 1000, 1100, 1800, 1500, 1700, 2100]
    juice_list = ["스프라이트", "코카콜라", "솔의눈", "펩시 콜라", "TOP커피", "꿀물", "홍삼차", "단팥죽"]
    cash_list = [50000, 10000, 5000, 1000, 500, 100]

    temperature = select_temperature()

    if (temperature == "1"):
        juice, price = cold(juice_list, price_list)
        print(juice)
    elif (temperature == "2"):
        juice, price = hot(juice_list, price_list)
        print(juice)
    else:
        print("잘못 입력하셨으므로 자판기가 종료됩니다.")
        exit

    payment = select_pay()

    if (payment == 1):
        sum = cash(0, price, cash_list)
        ret = cal(sum - price, cash_list)

    print("\n------------------------------")
    print("이용해주셔서 감사합니다.\n")
    print("[주문 음료]\n{}\n".format(juice))

    if (payment == 1):
        pay = str(sum)
        pay =  pay[:-3] + "," + pay[-3:]
        print("[투입 금액]\n{}원\n".format(pay))
        print("[잔돈]\n")
        for i in range(len(cash_list)):
            if (ret[i] != 0):
                print("{}원 동전 : {}개\n".format(cash_list[i], ret[i]))
    elif (payment == 2):
        pay = str(int(price * 1.1))
        pay =  pay[:-3] + "," + pay[-3:]
        print("[결제 금액]\n{}원".format(pay))
    else:
        print("잘못 입력하셨으므로 자판기가 종료됩니다.")
        exit

main()