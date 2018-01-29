<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>eNno Bootstrap Template</title>

    <!-- Bootstrap -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/animate.css">
    <link rel="stylesheet" href="/resources/css/font-awesome.min.css">
    <link rel="stylesheet" href="/resources/css/jquery.bxslider.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/demo.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/set1.css" />
    <link href="/resources/css/overwrite.css" rel="stylesheet">
    <link href="/resources/css/style.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <%@ include file="header.jsp"%>


    <div class="container">
        <div class="row">
            <div class="slider">
                <div class="img-responsive">
                    <ul class="bxslider">
                        <li><img src="/resources/img/01.jpg" alt=""/></li>
                        <li><img src="/resources/img/01.jpg" alt=""/></li>
                        <li><img src="/resources/img/01.jpg" alt=""/></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <div class="text-center">
                    <h2>Multi Purpose Theme</h2>
                    <p>Lorem ipsum dolor sit amet consectetur adipiscing elit Cras suscipit arcu<br>
                    vestibulum volutpat libero sollicitudin vitae Curabitur ac aliquam <br>
                    lorem sit amet scelerisque justo</p>
                </div>
                <hr>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="box">
                <div class="col-md-4">
                    <div class="wow bounceIn" data-wow-offset="0" data-wow-delay="0.4s">
                        <h4>Responsive</h4>
                            <div class="icon">
                                <i class="fa fa-heart-o fa-3x"></i>
                            </div>
                        <p>Lorem ipsum dolor sit amet consectetur adipiscing elit Cras suscipit arcu libero</p>
                        <div class="ficon">
                            <a href="#" class="btn btn-default" role="button">Read more</a>
                        </div>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="wow bounceIn" data-wow-offset="0" data-wow-delay="1.0s">
                        <h4>Multi Purpose</h4>
                        <div class="icon">
                            <i class="fa fa-desktop fa-3x"></i>
                        </div>
                        <p>Lorem ipsum dolor sit amet consectetur adipiscing elit Cras suscipit arcu libero</p>
                        <div class="ficon">
                            <a href="#" class="btn btn-default" role="button">Read more</a>
                        </div>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="wow bounceIn" data-wow-offset="0" data-wow-delay="1.6s">
                        <h4>Easy Customize</h4>
                        <div class="icon">
                            <i class="fa fa-location-arrow fa-3x"></i>
                        </div>
                        <p>Lorem ipsum dolor sit amet consectetur adipiscing elit Cras suscipit arcu libero</p>
                        <div class="ficon">
                            <a href="#" class="btn btn-default" role="button">Read more</a>
                        </div>
                    </div>

                </div>

            </div>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <div class="text-center">
                    <h2>Galleries</h2>
                    <p>Lorem ipsum dolor sit amet consectetur adipiscing elit Cras suscipit arcu<br>
                    vestibulum volutpat libero sollicitudin vitae Curabitur ac aliquam <br>
                    </p>
                </div>
                <hr>
            </div>
        </div>
    </div>

    <div class="content">
        <div class="grid">
            <figure class="effect-zoe">
                <img src="/resources/img/25.jpg" alt="img25"/>
                <figcaption>
                    <h2>Title <span>Name</span></h2>
                    <p class="icon-links">
                        <a href="#"><span class="icon-heart"></span></a>
                        <a href="#"><span class="icon-eye"></span></a>
                        <a href="#"><span class="icon-paper-clip"></span></a>
                    </p>
                    <p class="description">Zoe never had the patience of her sisters. She deliberately punched the bear in his face.</p>
                </figcaption>
            </figure>
            <figure class="effect-zoe">
                <img src="/resources/img/26.jpg" alt="img26"/>
                <figcaption>
                    <h2>Title <span>Name</span></h2>
                    <p class="icon-links">
                        <a href="#"><span class="icon-heart"></span></a>
                        <a href="#"><span class="icon-eye"></span></a>
                        <a href="#"><span class="icon-paper-clip"></span></a>
                    </p>
                    <p class="description">Zoe never had the patience of her sisters. She deliberately punched the bear in his face.</p>
                </figcaption>
            </figure>
        </div>
    </div>

    <div class="content">
        <div class="grid">
            <figure class="effect-zoe">
                <img src="/resources/img/27.jpg" alt="img27"/>
                <figcaption>
                    <h2>Title <span>Name</span></h2>
                    <p class="icon-links">
                        <a href="#"><span class="icon-heart"></span></a>
                        <a href="#"><span class="icon-eye"></span></a>
                        <a href="#"><span class="icon-paper-clip"></span></a>
                    </p>
                    <p class="description">Zoe never had the patience of her sisters. She deliberately punched the bear in his face.</p>
                </figcaption>
            </figure>
            <figure class="effect-zoe">
                <img src="/resources/img/30.jpg" alt="img30"/>
                <figcaption>
                    <h2>Title <span>Name</span></h2>
                    <p class="icon-links">
                        <a href="#"><span class="icon-heart"></span></a>
                        <a href="#"><span class="icon-eye"></span></a>
                        <a href="#"><span class="icon-paper-clip"></span></a>
                    </p>
                    <p class="description">Zoe never had the patience of her sisters. She deliberately punched the bear in his face.</p>
                </figcaption>
            </figure>
        </div>
    </div>

    <%@ include file="footer.jsp"%>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="/resources/js/jquery-2.1.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/resources/js/bootstrap.min.js"></script>
    <script src="/resources/js/wow.min.js"></script>
    <script src="/resources/js/jquery.easing.1.3.js"></script>
    <script src="/resources/js/jquery.isotope.min.js"></script>
    <script src="/resources/js/jquery.bxslider.min.js"></script>
    <script src="/resources/js/functions.js"></script>
  </body>
</html>
