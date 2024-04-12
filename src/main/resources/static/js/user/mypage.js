


window.onload = function() {

    if (document.getElementById("duplicationCheck")) {
        const $duplication = document.getElementById("duplicationCheck");

        $duplication.onclick = function () {

            let userId = document.getElementById("userId").value.trim();

            fetch("/user/mypage/idDupCheck", {
                method: "POST",
                headers: {
                    'Content-Type': 'application/json;charset=UTF-8'
                },
                body: JSON.stringify({userId: userId})
            })
                .then(result => result.text())
                .then(result => alert(result))
                .catch((error) => error.text().then((res) => alert(res)));
        }
    }

    /* 아이디 자릿수 유효성 검사 */
    if(document.getElementById("userId")) {
        const userId = document.querySelector('#userId');
        const userIdCheckMsg = document.querySelector('#userIdCheckMsg');
        const nameValidation = /^[a-zA-Z0-9_-]{6,20}$/;

        function userId_check() {
            if(nameValidation.test(userId.value)) {
                userIdCheckMsg.innerHTML = '사용할 수 있는 아이디 입니다.';
                userIdCheckMsg.style.color = 'green';
                userIdCheckMsg.style.display = 'block';
            } else {
                userIdCheckMsg.innerHTML = '아이디를 다시 입력해 주세요.';
                userIdCheckMsg.style.color = 'red';
                userIdCheckMsg.style.display = 'block';
            }
        }
        userId.addEventListener('focusout', userId_check);
    }

    if(document.getElementById("userPwd1")) {

        const userPwd1 = document.querySelector('#userPwd1');
        const userPwd2 = document.querySelector('#userPwd2');
        const userPwdCheckMsg1 = document.querySelector('#userPwdCheckMsg1');
        const userPwdCheckMsg2 = document.querySelector('#userPwdCheckMsg2');
        const pwValidation = /^.*(?=^.{8,20}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[~,!,^,@,#,$,*,(,),=,+,_,.,|]).*$/;

        function userPwd_check() {

            userPwdCheckMsg1.innerHTML = '';
            userPwdCheckMsg2.innerHTML = '';

            if(userPwd1.value.length < 8 || !pwValidation.test(userPwd1.value)) {
                userPwdCheckMsg1.innerHTML = '8자리 이상 영문, 숫자, 특수문자를 포함해야 합니다.';
                userPwdCheckMsg1.style.color = 'red';
                userPwdCheckMsg1.style.display = 'block';
            } else if( userPwd1.value !== userPwd2.value ) {
                userPwdCheckMsg2.innerHTML = '비밀번호를 확인해 주세요';
                userPwdCheckMsg2.style.color = 'red';
                userPwdCheckMsg2.style.display = 'block';
            } else {
                userPwdCheckMsg1.innerHTML = '사용 하실 수 있습니다.';
                userPwdCheckMsg1.style.color = 'green';
                userPwdCheckMsg1.style.display = 'block';
                userPwdCheckMsg2.innerHTML = '사용 하실 수 있습니다.';
                userPwdCheckMsg2.style.color = 'green';
                userPwdCheckMsg2.style.display = 'block';
            }
        }
        userPwd1.addEventListener('focusout', userPwd_check);
        userPwd2.addEventListener('focusout', userPwd_check);
    }

    if(document.getElementById('birth')) {
        /* 년도(birth-year) 옵션 생성 */
        const yearSelect = document.getElementById("birth-year");
        const currentYear = new Date().getFullYear();
        for(let i = currentYear; i >= currentYear - 100; i-- ) {
            const option = document.createElement("option");
            option.text = i;
            option.value = i;
            yearSelect.add(option);
        }

        /* 월(birth-month) 옵션 생성 */
        const monthSelect = document.getElementById("birth-month");
        for(let i = 1; i <= 12; i++) {
            const option = document.createElement("option");
            option.text = i;
            /* 한자리 숫자는 앞에 0이 붙음 */
            option.value = i < 10 ? "0" + i : i;
            monthSelect.add(option);
        }

        /* 일(birth-day) 옵션 생성 */
        const daySelect = document.getElementById("birth-day");
        for(let i = 1; i <= 31; i++) {
            const option = document.createElement("option");
            option.text = i;
            /* 한자리 숫자는 앞에 0이 붙음 */
            option.value = i < 10 ? "0" + i : i;
            daySelect.add(option);
        }
    }

    /* 약관 동의 전체 선택 및 필수항목 선택시 가입 */
    const termsCheckBox = document.getElementById("termsCheckBox");
    if("termsCheckBox") {
        const agreeAll = document.getElementById("agree-all");
        const mustAgreeCheckboxes = document.querySelectorAll('.mustAgree');
        const selectAgreeCheckboxes = document.querySelectorAll('.selectAgree');
        const signUpButton = document.querySelector('.signUp');

        /* 전체 체크 박스 클릭 이벤트 핸들러 */
        agreeAll.addEventListener("click", function () {
            mustAgreeCheckboxes.forEach(function (checkbox) {
                checkbox.checked = agreeAll.checked;
            });
            selectAgreeCheckboxes.forEach(function (checkbox) {
                checkbox.checked = agreeAll.checked;
            })
        });

        /* 가입하기 버튼 이벤트 핸들러 */
        signUpButton.addEventListener('click', function (event) {

            const requiredAgreements = document.querySelectorAll('.mustAgree:checked');
            const selectedAgreements = document.querySelectorAll('.selectAgree:checked');

            const allRequiredChecked = requiredAgreements.length === mustAgreeCheckboxes.length;

            if(!allRequiredChecked) {
                alert("필수 항목에 모두 동의해야 합니다.");
                // 페이지 이동 차단
                event.preventDefault();
            } else {
                window.location.href = "/user/mypage/login";
            }
        });
    }
}



