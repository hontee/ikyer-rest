<@overried name="body">
<div class="container">
    <div class="columns">
        <div class="one-half column centered">
            <h2>用户注册</h2>
            <form>
                <dl class="form-group">
                    <dt><label>用户名</label></dt>
                    <dd><input class="form-control" name="username" placeholder="用户名"></dd>
                </dl>
                <dl class="form-group">
                    <dt><label>邮箱</label></dt>
                    <dd><input class="form-control" type="email" name="email" placeholder="邮箱"></dd>
                </dl>
                <dl class="form-group">
                    <dt><label>密码</label></dt>
                    <dd><input class="form-control" type="password" name="password" placeholder="登录密码"></dd>
                </dl>
                <dl class="form-control">
                    <button type="button" class="btn btn-primary btn-block">完成注册</button>
                </dl>
                <p class="note">通过点击 <strong>完成注册</strong>，表示您已同意我们的 <a href="#">服务条款与隐私政策</a>。</p>
            </form>
        </div>
    </div>
</div>
</@overried>

<@extends name="../base.ftl"/>