// 11_quiz_array_function.js
// alert('js 파일 적용 확인!!!');

// 점수를 등록할 배열에 점수를 입력받아 등록
function inputScore(arrays, size, subject){
    for(let i=0; i < size; i++){
        let score = prompt(subject+"과목에 점수를 입력해주세요!");
        score = parseInt(score);
        // arrays[i] = score;
        arrays.push(score);
    }
    // 점수 등록 완료된 배열 반환
    return arrays;
}

// 최대값
function maxScore(arrays){
    let max = arrays[0];
    for(let score of arrays){
        if(score > max){
            max = score;
        }
    }
    return max;
}

// 최소값
function minScore(arrays){
    let min = arrays[0];
    for(let index in arrays){
        if(min > arrays[index]){
            min = arrays[index];
        }
    }
    return min;
}

// 전체 합계
function totalValue(arrays){
    let sum = 0;
    for(let i = 0; i < arrays.length; i++){
        sum = sum + arrays[i];
        //sum += arrays[i];
    }
    return sum;
}

// 전체 평균
function average(total , size){
    return total / size;
}