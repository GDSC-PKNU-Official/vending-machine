const fs = require('fs');

const vending_machine_main = require('./main.js');

class vending_machine_user extends vending_machine_main {
    user_ice_or_hot() {
        console.log("음료를 선택 해주세요!");

        const select_arr = this.output_for_data(this.select);
    
        this.select_1_data = this.read_data(select_arr, this.select, 1);
        console.log('[' + this.select_1_data + ']');
        
        if(this.select_1_data === 'admin') {
            this.admin_main();
        } else {
            this.user_select_drink();
        }
    }

    user_select_drink() {
        const select_arr = this.output_for_data(this.select[this.select_1_data]);

        this.select_2_data = this.read_data(select_arr, this.select[this.select_1_data]);
        console.log('[' + this.select_2_data + ']');

        this.user_select_pay();
    }

    user_select_pay() {
        console.log("[결제 방식 선택]");

        const select_arr = this.output_for_data(this.how, 1);

        this.select_3_data = this.read_data(select_arr, this.how);
        console.log("[" + this.select_3_data + "]");

        if(this.how[this.select_3_data][0] === 1) {
            this.user_end();
        } else {
            this.user_calc_cash();
        }
    }

    user_calc_cash() {
        const select_arr = this.output_for_data(this.count, 2);

        let money_count = 0;
        while(1) {
            this.select_4_data = this.read_data(select_arr, this.count);
            
            money_count += this.count[this.select_4_data];
            if(this.count[this.select_4_data] === '') {
                money_count = 0;
            }

            if(money_count >= this.select[this.select_1_data][this.select_2_data]) {
                break;
            }
        }

        console.log("[투입 금액]");
        console.log("[" + String(money_count) + "]");

        let return_money = money_count - this.select[this.select_1_data][this.select_2_data];
        let currency = [];
        for(let for_a = 0; for_a < Object.keys(this.count).length; for_a++) {
            if(this.count[Object.keys(this.count)[for_a]] !== '') {
                currency.push(this.count[Object.keys(this.count)[for_a]]);
            }
        }

        console.log(return_money);

        let end = {};
        let cursor = 0;
        while(1) {
            if(return_money === 0) {
                break;
            }

            if(return_money >= currency[cursor]) {
                if(end[currency[cursor]]) {
                    end[currency[cursor]] += 1;
                } else {
                    end[currency[cursor]] = 1;
                }
                
                return_money -= currency[cursor];
            } else {
                cursor += 1;
            }
        }

        this.user_end(1);

        console.log("[잔돈]");
        for(let for_a = 0; for_a < Object.keys(end).length; for_a++) {
            console.log(Object.keys(end)[for_a] + ' : ' + String(end[Object.keys(end)[for_a]]) + '개');
        }
    }

    user_end(do_type = 0) {
        console.log("이용해주셔서 감사합니다.");

        console.log("[주문 음료]");
        console.log(this.select_2_data);

        console.log("[결제 금액]");
        let count = 0;
        if(do_type === 0) {
            count = this.select[this.select_1_data][this.select_2_data] + (this.select[this.select_1_data][this.select_2_data] * 0.1);
            console.log(count);
        } else {
            count = this.select[this.select_1_data][this.select_2_data];
            console.log(count);
        }

        let data = JSON.parse(fs.readFileSync('./data.json', 'utf8'));
        data[3] += count;
        fs.writeFileSync('data.json', JSON.stringify(data));
    }
}
module.exports = vending_machine_user;