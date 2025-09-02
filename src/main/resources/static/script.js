const memoList = document.querySelector('#memo-list');
const memoForm = document.querySelector('#memo-form');
const memoContent = document.querySelector('#memo-content');

// 모든 메모를 가져와서 화면에 그리는 함수
async function fetchMemos() {
    const response = await fetch('/api/memos');
    const memos = await response.json();

    memoList.innerHTML = '';
    for (const memo of memos) {
        const li = document.createElement('li');
        li.innerHTML = `<p>${memo.content}</p>`
        memoList.appendChild(li);
    }
}
// 메모를 추가하는 함수 (form)
// 각각의 메모를 누르면 삭제되는 함수

fetchMemos();