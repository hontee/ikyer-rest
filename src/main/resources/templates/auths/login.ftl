<@override name="body">
<div class="container">
    <div class="columns">
        <div class="one-half column centered">
            <h2>用户登录</h2>
            <form>
                <dl class="form-group">
                    <dt><label>用户名</label></dt>
                    <dd><input class="form-control" name="username" placeholder="用户名 / 邮箱"></dd>
                </dl>
                <dl class="form-group">
                    <dt><label>密码</label><span class="right"><a href="#">忘记密码</a></span></dt>
                    <dd><input class="form-control" type="password" name="password" placeholder="登录密码"></dd>
                </dl>
                <dl class="form-control">
                    <button type="button" class="btn btn-primary btn-block">登录</button>
                </dl>
            </form>
        </div>
    </div>
</div>
</@override>

<@extends name="../base.ftl"/>