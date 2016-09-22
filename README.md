# 一个基于giiwa框架 mockserver模块
关于giiwa， 请参阅 http://giiwa.org
用于Ajax／App API原型开发和调试的mock server。
<h1>功能介绍</h1>
<ul>
<li>uri管理，填写uri及返回类型、结果</li>
<li>接受web request，并按填写的结果和类型返回</li>
</ul>

<h1>开发使用</h1>
<ul>
<li>下载所有源码，然后直接导入Eclipse， 修改...</li>
<li>进入项目目录， 直接运行 ant编译打包, 会生成 mockserver_1.0.1_????.zip </li>
<li>在你安装的giiwa 服务器中， 进入后台管理->系统管理->模块管理->上传模块，然后重启giiwa</li>
<li>重启后，进入后台管理->mockserver－>url管理，添加／删除连接。</li>
</ul>

所有填写的URL并不会覆盖原有的url。 在整个系统中，优先级最低。
 
