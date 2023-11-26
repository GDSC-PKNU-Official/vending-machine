const readlineSync = require('readline-sync');  

const coldDrinks = {
  '1': { name: '스프라이트', price: 1500 },
  '2': { name: '코카콜라', price: 1300 },
  '3': { name: '솔의눈', price: 1000 },
  '4': { name: '펩시 콜라', price: 1100 },
};

const hotDrinks = {
  '1': { name: 'TOP커피', price: 1800 },
  '2': { name: '꿀물', price: 1500 },
  '3': { name: '홍삼차', price: 1700 },
  '4': { name: '단팥죽', price: 2100 },
};

function insertCash(totalAmount) {
  console.log(`[현금 투입 : ${totalAmount}원]`);
  console.log('[1] 5만원권 \n[2] 1만원권 \n[3] 5천원권 \n[4] 1천원권 \n[5] 500원 동전 \n[6] 100원 동전 \n[0] 반환');

  const choice = readlineSync.question('사용자 입력 > ');

  if (choice === '0') { 
    return 0;
  } else {
    const denomination = [50000, 10000, 5000, 1000, 500, 100];
    const selectedDenomination = denomination[parseInt(choice, 10) - 1];

    return totalAmount + selectedDenomination;
  }
}

function calculateChange(amount, totalPrice) {
    return amount - totalPrice;
  }

function calculateVAT(price) {
    return price * 0.1;
  }

function printOrderDetails(drinkName, paymentType, totalPrice, change) {
  console.log(`이용해주셔서 감사합니다.\n[주문 음료] \n${drinkName}\n[투입 금액]\n${totalPrice}원\n[잔돈] \n${change}원`);
}

function runVendingMachine() {
  console.log('[어서와요! GDSC 음료 자판기]\n계속 하려면 아무키나 입력하세요 ...');
  readlineSync.keyInPause();

  console.log('------------------------------\n음료를 선택 해주세요!\n[1] 차가운 음료\n[2] 따뜻한 음료');
  const drinkType = readlineSync.question('사용자 입력 > ');

  let selectedDrink;
  if (drinkType === '1') {
    console.log('------------------------------\n[차가운 음료]');
    for (const key in coldDrinks) {
      console.log(`[${key}] ${coldDrinks[key].name} : ${coldDrinks[key].price}원`);
    }
    const coldDrinkChoice = readlineSync.question('사용자 입력 > ');
    selectedDrink = coldDrinks[coldDrinkChoice];
  } else if (drinkType === '2') {
    console.log('------------------------------\n[따뜻한 음료]');
    for (const key in hotDrinks) {
      console.log(`[${key}] ${hotDrinks[key].name} : ${hotDrinks[key].price}원`);
    }
    const hotDrinkChoice = readlineSync.question('사용자 입력 > ');
    selectedDrink = hotDrinks[hotDrinkChoice];
  }

  console.log('------------------------------\n[결제 방식 선택]\n[1] 현금\n[2] 카드 (부가세 10% 적용)');
  const paymentType = readlineSync.question('사용자 입력 > ');

  let totalPrice;
  if (paymentType === '1') {
    totalPrice = selectedDrink.price;
    let totalAmount = 0;

    while (totalAmount < totalPrice) {
      totalAmount = insertCash(totalAmount);
    }

    const change = calculateChange(totalAmount, totalPrice);
    printOrderDetails(selectedDrink.name, '현금', totalPrice, change);
  } else if (paymentType === '2') {
    const vat = calculateVAT(selectedDrink.price);
    totalPrice = selectedDrink.price + vat;
    printOrderDetails(selectedDrink.name, '카드', totalPrice, 0);
  }
}

runVendingMachine();
