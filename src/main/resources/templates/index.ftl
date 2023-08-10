<!DOCTYPE html>
<html>
<head>
    <title>首页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="applicable-device" content="pc,mobile">
    <link href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/index.css" rel="stylesheet">
    <script src="/webjars/jquery/3.1.1-1/jquery.min.js"></script>
    <script src="/static/index.js"></script>
</head>
<body>
<noscript><h2 style="color: #ff0000">Seems your browser doesn't support Javascript! Websocket relies on Javascript being
        enabled. Please enable
        Javascript and reload this page!</h2></noscript>
<#include "topbar.ftl">
<div id="main-content">
<#--    <div class="jumbotron">-->
<#--        <p>Hello, world!</p>-->
<#--        <p>...</p>-->
<#--        <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a></p>-->
<#--    </div>-->
    <a href="/chat" >人机对话 Chat</a>
    <a href="/summary" >内容总结 Summary</a>
    <a href="/classic" >文本分类 Classic</a>
    <a href="/duplication" >查重 DuplicationCheck</a>
    <a href="/sentiment" >情感分析 SentimentAnalysis</a>
    <a href="/keyword" >关键词提取 Keyword</a>
    <a href="/translate" >翻译 Translate</a>
    <a href="/txtToImage" >文生图 Txt2Image</a>
</div>
</body>
</html>