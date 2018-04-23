var UserIdInput=React.createClass({
    getInitialState:function(){
        return {
            userId:""
        }
    },
    onchange:function(event){
        this.setState({userId:event.target.value});
    },
    render:function() {
        return <p className="line">
            		<label>编&nbsp;号:</label>
            		<input type="text" defaultValue={this.state.userId} onChange={this.onchange} className="input"/>
        		</p>
    }
});
var UserNameInput=React.createClass({
    getInitialState:function(){
        return {
            userName:""
        }
    },
    onchange:function(event){
        this.setState({userName:event.target.value});
    },
    render:function() {
        return <p className="line">
                    <label>用户名:</label>
                    <input type="text" defaultValue={this.state.userName} onChange={this.onchange} className="input"/>
                </p>
    }
});
var UserPwdInput=React.createClass({
    getInitialState:function(){
        return {
            userPwd:""
        }
    },
    onchange:function(event){
        this.setState({userPwd:event.target.value});
    },
    render:function() {

        return <p className="line">
                   <label>密&nbsp;码:</label>
                   <input type="text" defaultValue={this.state.userPwd} onChange={this.onchange} className="input"/>
               </p>
    }
});
var UserAgeInput=React.createClass({
    getInitialState:function(){
        return {
            userAge:""
        }
    },
    onchange:function(event){
        this.setState({userAge:event.target.value});
    },
    render:function() {

        return <p className="line">
                   <label>年&nbsp;龄:</label>
                   <input type="text" defaultValue={this.state.userAge} onChange={this.onchange} className="input"/>
               </p>
    }
});
var RegisterForm=React.createClass({
    onclick:function(){
        $.ajax({
            url:"addServlet",
            type:"get",
            data:"userId="+this.refs.userId.state.userId+"&userName="+this.refs.userName.state.userName+"&userPwd="+this.refs.userPwd.state.userPwd+"&userAge="+this.refs.userAge.state.userAge,
            dataType:"json",
            success:function(data){
                if(data!=null)
                {
                    alert("注册成功");
                }
                location.reload();
                
            }.bind(this),
            error:function(XMLHttpRequest, textStatus, errorThrown){
            	alert(textStatus);
            }
        });

    },
    render:function(){
        return <div className="show">
        	        <UserIdInput ref="userId"/>
                    <UserNameInput ref="userName"/>
                    <UserPwdInput ref="userPwd"/>
                    <UserAgeInput ref="userAge"/>
                    <input type="button" value="注册" onClick={this.onclick} className="btn"/>
                </div>
    }
});
ReactDOM.render(
    <div>
        <RegisterForm/>
    </div>,
    document.getElementById("main")
);
