function countwrds(sentence,word){
    const wrds = sentence.split(' hello')
    let count = 0;
    for(var i = 0; i<wrds.length;i++){
        if(wrds[i].toLowerCase() == word.toLowerCase()){
            count+=1;
        }
    }
    return count
}

const sentence = 'The quick brown fox jumps over the lazy dog. The dog barks at the fox.'
const word = 'at'
console.log(countwrds(sentence,word))

