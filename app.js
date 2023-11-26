const reader = require('readline-sync');
const fs = require('fs');

class vending_machine {
    constructor() {
        const data = JSON.parse(fs.readFileSync('./data.json', 'utf8'));
        
        this.select = data[0];
        this.how = data[1];
        this.count = data[2];
        this.all = data[3];

        this.auth = '사용자';
    }

    refresh() {
        const data = JSON.parse(fs.readFileSync('./data.json', 'utf8'));
        
        this.select = data[0];
        this.how = data[1];
        this.count = data[2];
        this.all = data[3];

        this.auth = '사용자';
    }

    read_data(select_arr, arr, do_type = 0) {
        let input;
        while(1) {
            process.stdout.write(this.auth + " 입력 > ");
            input = reader.question();
            if(Object.keys(select_arr).includes(input) || (do_type === 1 && input === 'admin')) {
                break;
            } else {
                console.log("잘못된 입력");
            }
        }
        
        if(input !== 'admin') {
            input = Object.keys(arr)[Number(input) - 1];
        }
        
        return input;
    }

    output_for_data(select, data_type = 0) {
        let select_length = Object.keys(select).length;
        let select_arr = {};
        for(let for_a = 0; for_a < select_length; for_a++) {
            if(data_type === 2 && select[Object.keys(select)[for_a]] === '') {
                console.log("[0] " + Object.keys(select)[for_a]);
                select_arr[0] = Object.keys(select)[for_a];
            } else {
                process.stdout.write("[" + String(for_a + 1) + "] " + Object.keys(select)[for_a]);
                if(data_type === 1 && select[Object.keys(select)[for_a]][1] !== '') {
                    console.log(" (" + select[Object.keys(select)[for_a]][1] + ")");
                } else {
                    console.log("");
                }
                
                select_arr[for_a + 1] = Object.keys(select)[for_a];
            }
        }

        return select_arr;
    }

    start() {
        console.log("[어서와요! GDSC 음료 자판기]");

        this.user_ice_or_hot();
    }

    admin_main() {
        console.log('[관리자 페이지]');
        this.auth = "admin";

        let select = {
            "총 수익 확인" : "",
            "음료 관리" : ""
        }
        let select_arr = this.output_for_data(select);

        this.admin_select_0 = this.read_data(select_arr, select);
        console.log('[' + this.admin_select_0 + ']');

        if(this.admin_select_0 === Object.keys(select)[0]) {
            this.admin_total_profit();
        } else {
            this.admin_drink_manager();
        }
    }

    admin_total_profit() {
        console.log('[관리자 페이지 - 총 수익]');
        console.log(String(this.all) + '원');
    }

    admin_drink_manager() {
        console.log('[관리자 페이지 - 음료 관리]');

        let select = {
            "음료 확인" : "",
            "음료 추가" : "",
            "음료 삭제" : ""
        }
        let select_arr = this.output_for_data(select);

        this.admin_select_1 = this.read_data(select_arr, select);
        console.log('[' + this.admin_select_1 + ']');

        if(this.admin_select_1 === Object.keys(select)[0]) {
            this.admin_drink_list();
        } else if(this.admin_select_1 === Object.keys(select)[1]) {
            this.admin_add_drink();
        } else {
            this.admin_remove_drink();
        }
    }

    admin_drink_list() {
        let select_length = Object.keys(this.select).length;
        for(let for_a = 0; for_a < select_length; for_a++) {
            console.log('[' + Object.keys(this.select)[for_a] + ']');
            this.output_for_data(this.select[Object.keys(this.select)[for_a]]);
        }
    }

    admin_add_drink() {
        console.log("음료를 선택 해주세요!");

        let select_arr = this.output_for_data(this.select);
    
        this.admin_page_3_select = this.read_data(select_arr, this.select);
        console.log('[' + this.admin_page_3_select + ']');
        
        console.log('음료 이름을 설정하세요');
        
        process.stdout.write("admin 입력 > ");
        let input = reader.question();
        let name = input;

        console.log('음료 가격을 설정하세요');
        let money = 0;
        while(1) {
            process.stdout.write("admin 입력 > ");
            input = reader.question();
            
            if(input.match(/^[0-9]+$/)) {    
                money = Number(input);
                break;
            }
        }

        let data = JSON.parse(fs.readFileSync('./data.json', 'utf8'));
        data[0][this.admin_page_3_select][name] = money;
        fs.writeFileSync('data.json', JSON.stringify(data));

        console.log('[관리자 페이지 - 추가완료]');
        console.log(name + ' : ' + money);
    }

    admin_remove_drink() {
        console.log("음료를 선택 해주세요!");

        let select_arr = this.output_for_data(this.select);
    
        this.admin_page_3_select = this.read_data(select_arr, this.select);
        console.log('[' + this.admin_page_3_select + ']');

        let select_arr_2 = this.output_for_data(this.select[this.admin_page_3_select]);

        this.admin_page_3_select_2 = this.read_data(select_arr_2, this.select[this.admin_page_3_select]);
        console.log('[' + this.admin_page_3_select_2 + ']');

        let data = JSON.parse(fs.readFileSync('./data.json', 'utf8'));

        console.log('[관리자 페이지 - 음료 삭제 완료]');
        console.log(this.admin_page_3_select_2 + ' : ' + data[0][this.admin_page_3_select][this.admin_page_3_select_2]);

        delete data[0][this.admin_page_3_select][this.admin_page_3_select_2];
        fs.writeFileSync('data.json', JSON.stringify(data));
    }

    user_ice_or_hot() {
        console.log("음료를 선택 해주세요!");

        let select_arr = this.output_for_data(this.select);
    
        this.select_1_data = this.read_data(select_arr, this.select, 1);
        console.log('[' + this.select_1_data + ']');
        
        if(this.select_1_data === 'admin') {
            this.admin_main();
        } else {
            this.user_select_drink();
        }
    }

    user_select_drink() {
        let select_arr = this.output_for_data(this.select[this.select_1_data]);

        this.select_2_data = this.read_data(select_arr, this.select[this.select_1_data]);
        console.log('[' + this.select_2_data + ']');

        this.user_select_pay();
    }

    user_select_pay() {
        console.log("[결제 방식 선택]");

        let select_arr = this.output_for_data(this.how, 1);

        this.select_3_data = this.read_data(select_arr, this.how);
        console.log("[" + this.select_3_data + "]");

        if(this.how[this.select_3_data][0] === 1) {
            this.user_end();
        } else {
            this.user_calc_cash();
        }
    }

    user_calc_cash() {
        let select_arr = this.output_for_data(this.count, 2);

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

const new_vending_machine = new vending_machine();
new_vending_machine.start();