

function join() {
	let id = document.querySelector('#id')
	let pw = document.querySelector('#pw')
	let name = document.querySelector('#name')
	let phone = document.querySelector('#phone')

	var param = {
		user_id : id.value,
		user_pw : pw.value,
		user_nm : name.value,
		user_phone : phone.value
	}
	console.log(param)
	
	fetch(`/user/joinProc`, {
			method: 'POST',
			headers: {
		'Content-Type': 'application/json'
			},
			body:JSON.stringify(param)
		}).then(function(res) {
			return res.json()
		}).then(function(data) {
			console.log(data)
			alert(data.message)
		})
}