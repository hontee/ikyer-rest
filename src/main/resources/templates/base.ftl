<!DOCTYPE html>
<html class="no-js" lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="renderer" content="webkit">
  <meta property="ht:user" content="${user!}">
  <meta name="keywords" content="${keywords!"快易,ikyer,开发者,开发者服务,资源,文档,开发工具,开源项目,SDK,API,数据平台"}">
  <meta name="description" content="${description!"快易（ikyer.com）是一个基于学习和分享的开发者社区，我们以汇聚国内外最优质资源，打造最有影响力的开发者平台为目标，专注于为开发者服务。"}">

  <title>${title!"快易开发者服务平台 · ikyer.com"}</title>
  <link rel="apple-touch-icon" href="/apple-touch-icon.png">
  <link rel="shortcut icon" href="/favicon.ico">
  <@block name="resources">
  <link href="${urls.getForLookupPath('/css/primer.css')}" rel="stylesheet">
  </@block>
</head>

<body>
<!--[if lt IE 8]>
<div class="toolbar">
  <div class="container">
    <div class="flash flash-warn">您使用的浏览器版本过低，为获得更好的体验，请升级您的浏览器！</div>
  </div>
</div>
<![endif]-->

<@block name="navbar">
<div class="container">
    <h1>快易</h1>
    <div class="search">
        <form>
            <input class="form-control" type="text" value="Example Value">
        </form>
    </div>
    <ul>
        <li>我的主页</li>
        <li>发现</li>
        <li>分享</li>
        <li>关于</li>
    </ul>
    <div>登录 / 注册</div>
</div>
</@block>

<@block name="body"></@block>

<@block name="footer">
  <link href="${urls.getForLookupPath('/js/vendor/validator/jquery.validator.css')}" rel="stylesheet">
  <script src="${urls.getForLookupPath('/js/vendor/modernizr-2.8.3.min.js')}"></script>
  <script src="${urls.getForLookupPath('/js/vendor/jquery-2.1.4.min.js')}"></script>
  <script src="${urls.getForLookupPath('/js/vendor/validator/jquery.validator.min.js')}?local=zh-CN"></script>
</@block>
</body>
</html>