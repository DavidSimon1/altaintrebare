/**
 * Created by condor on 04/02/17
 */
//afisare prin json
function listQuestions(questions) {
    //var list = document.getElementById('listOfQuestions');
    var list = document.getElementById('listOfQuestions').getElementsByTagName('ul')[0];  //
    var listHtml = '';

    for (var i = 0; i < questions.length; i++) {
        var question = questions[i];
        //listHtml= listHtml+question+'</br>';

        var el= '<li>'+question+'</li>';
        listHtml=listHtml+el;
    }
    list.innerHTML = listHtml;
}

// cazul cand nu folosim o lista html
function listQuestions1(questions) {
    var list = document.getElementById('listOfQuestions');
    var listHtml = '';

    for (var i = 0; i < questions.length; i++) {
        var question = questions[i];
        listHtml=listHtml+question+'</br>';
    }
    list.innerHTML = listHtml;  //afisare pe ecran
}

//apelam un server care aduce json
function loadQuestions() {
    $.ajax({
        url: 'aq?action=list'
    }).done(function (response) {
        listQuestions(response.questions);
    });
}


// buggy one
// accepts empty strings
// accepts html code (script injections as well)
/// etc
//$,ajax - apeleaza server-ul
//anotherquestion.html - intoarcere inapoi in pagina
function addQuestion() {
    var questionInput = document.getElementById('questionInput').value;
    $.ajax({
        url: 'aq?value='+questionInput
    }).done(function (response) {
        location.href = "anotherquestion.html";
    });
}