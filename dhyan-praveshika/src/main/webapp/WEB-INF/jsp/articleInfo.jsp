<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="u" %>
<!DOCTYPE html>
<html lang="en-gb" dir="ltr" xmlns:fb="http://ogp.me/ns/fb#">
<head>


  <base href="http://dhyanpraveshika.org/index.php/175-tantra-s-origins" />
  <meta http-equiv="content-type" content="text/html; charset=utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="HandheldFriendly" content="true" />
  <meta name="apple-mobile-web-app-capable" content="YES" />
  
  <meta name="keywords"
    content="dhyan praveshika, dhyan praveshika india, spiritual learning, spirituality, e magazine, indian philosophy, ayurvedic blog, spiritual magazine, spiritual articles, spirituality and healing, new age magazine, spiritual india" />
  <meta name="author" content="${blog.author}" />
  <meta name="copyright" content="Copyright © 2019 TemPlaza. All Rights Reserved." />

  <%-- <meta name="description" content="${blog.description}" /> --%>
  <meta name="category" content="${blog.category}" />
  <meta name="title" content="${blog.title}" />
  <meta name="date" content="${blog.created_date}" />
  <meta name="generator" content="Joomla! - Open Source Content Management" />
  <title>Dhyan Praveshika</title>

  <link href="http://dhyanpraveshika.org/index.php/175-tantra-s-origins" rel="canonical" />
  <link href="/templates/tz_dreame/favicon.ico" rel="shortcut icon" type="image/vnd.microsoft.icon" />
  <link rel="stylesheet" href="/components/com_tz_portfolio/css/tzportfolio.css" type="text/css" />
  <link rel="stylesheet" href="/templates/system/css/system.css" type="text/css" />
  <link rel="stylesheet" href="/templates/tz_dreame/css/themes/block/bootstrap.css" type="text/css" />
  <link rel="stylesheet" href="/templates/tz_dreame/css/themes/block/bootstrap-responsive.css" type="text/css" />
  <link rel="stylesheet" href="/templates/tz_dreame/css/themes/block/template.css" type="text/css" />
  <link rel="stylesheet" href="/plugins/system/plazart/base/css/off-canvas.css" type="text/css" />
  <link rel="stylesheet" href="/templates/tz_dreame/css/themes/block/template.css" type="text/css" />
  <link rel="stylesheet" href="http://dhyanpraveshika.org/templates/tz_dreame/fonts/RalewayRegular/stylesheet.css"
    type="text/css" />
  <link rel="stylesheet" href="http://dhyanpraveshika.org/templates/tz_dreame/fonts/PTSansItalic/stylesheet.css"
    type="text/css" />
  <link rel="stylesheet"
    href="http://dhyanpraveshika.org/templates/tz_dreame/fonts/libre_baskervilleitalic/stylesheet.css"
    type="text/css" />
  <link rel="stylesheet" href="http://dhyanpraveshika.org/templates/tz_dreame/fonts/OpenSansItalic/stylesheet.css"
    type="text/css" />
  <link rel="stylesheet" href="http://dhyanpraveshika.org/templates/tz_dreame/fonts/RalewayLight/stylesheet.css"
    type="text/css" />
  <link rel="stylesheet" href="/plugins/system/plazart/base/css/megamenu.css" type="text/css" />
  <link rel="stylesheet" href="/plugins/system/plazart/base/css/megamenu-responsive.css" type="text/css" />
  <link rel="stylesheet" href="/templates/tz_dreame/css/themes/block/megamenu.css" type="text/css" />
  <link rel="stylesheet" href="/templates/tz_dreame/css/themes/block/megamenu-responsive.css" type="text/css" />
  <link rel="stylesheet" href="http://dhyanpraveshika.org/modules/mod_osdonate/css/style.css" type="text/css" />
  <link rel="stylesheet" href="/media/com_acymailing/css/module_default.css?v=1438155523" type="text/css" />
  <style type="text/css">
    .fb_iframe_widget {
      max-width: none;
    }

    .fb_iframe_widget_lift {
      max-width: none;
    }

    @media print {

      .css_buttons0,
      .css_buttons1,
      .css_fb_like,
      .css_fb_share,
      .css_fb_send,
      css_fb_photo,
      .css_fb_comments,
      .css_fb_comments_count {
        display: none
      }
    }

    .container-fluid {
      max-width: 100% !important;
    }

    .tz_portfolio_video {
      width: 400px;
      margin: 0px auto !important;
    }

    .item-page {
      background: #f4f4f4 !important
    }

    .item-page time {
      display: none !important
    }

    body,
    div.tz_portfolio_user a,
    input {
      font-family: RalewayRegular, Arial, sans-serif;
    }

    .sidebar-nav h3,
    div.tz_portfolio_user a:hover,
    a.btn,
    div.TzPagination a,
    .table-title,
    .btn,
    #tz_options a,
    .TzArticleTitle,
    .sidebar-nav li a {
      font-family: RalewayRegular, Arial, sans-serif;
    }

    .tagName,
    .PTitalic {
      font-family: PTSansItalic, Arial, sans-serif;
    }

    div.TzInnerQuote,
    .TzQuote {
      font-family: libre_baskervilleitalic, Arial, sans-serif;
    }

    #TzContent h3.title_feature,
    .page-heading,
    .TzArticleBlogInfo,
    h3.TzBlogTitle a,
    h2.title-timeline,
    .page-header>h1,
    h3.TzArticleAuthorTitle {
      font-family: RalewayRegular, Arial, sans-serif;
    }

    .TzArticleInfo,
    .tztwd-tweet-container {
      font-family: OpenSansItalic, Arial, sans-serif;
    }

    .tz_feature_item h3.title_feature a {
      font-family: RalewayLight, Arial, sans-serif;
    }


    div.TzBlog .TzItemsLeading,
    div.TzBlog .TzItemsRow,
    div#TzContent .tz_item .TzInner,
    .contact .ContactInner,
    .tz-content-inner,
    .weblink-category,
    .TzBlog .tz_portfolio_user,
    div#TzContent .TzInner .tz-title-timeline,
    .item-page,
    #tz-typography,
    .TzCategories,
    .search {
      background-color: #ffffff;
    }


    div.sidebar-nav,
    #sidebar-left,
    header.tz-header {
      background-color: #ffffff;
      position:relative;
    }


    body {
      background-color: #f4f4f4;
    }


    .sidebar-nav .box input,
    div input,
    div textarea {
      background-color: #fff !important;
    }


    #tz-component {
      max-width: 990px;
      width: auto;
      margin: 0 auto;
    }



    .TzBlog .TzQuote,
    div#TzContent .tz_item div.TzInnerQuote {
      background-image: url(http://dhyanpraveshika.org/images/quote_item.png);

    }

    .TzBlog .TzLink .TzBlogTitle a,
    div#TzContent .tz_item div.TzInnerLink {
      background-image: url(http://dhyanpraveshika.org/images/link_item.png);

    }

    .off-canvas #off-canvas-nav .plazart-mainnav {
      background: url(http://dhyanpraveshika.org/images/menu-item-mobile.png) repeat;

    }

    #off-canvas-nav ul li a,
    #off-canvas-nav .always-show .dropdown-menu ul li a {
      color: #bbbbbb;
      border-bottom: 1px solid #383838 !important;
    }

    #off-canvas-nav .caret {
      background: url(http://dhyanpraveshika.org/images/btn_dropdown.png) center no-repeat;
    }

    #off-canvas-nav .nav-child {
      background: url(http://dhyanpraveshika.org/images/menu-bg-mobile.png) center repeat !important;
    }

    .TzPortfolioDate {
      border-color: #CCCCCC;
    }


    .sidebar-nav .box input,
    div input,
    div textarea {
      border-color: #d9dbdc !important;
    }

    div.tz-transparent {
      background-image: url(http://dhyanpraveshika.org/images/bg-transparent.png);
      background-repeat: repeat-x;
      background-position: center top;
    }

    div#TzContent .tz_item h3 a,
    div#TzContent .TzItem h3 a,
    .item-page h2,
    div.TzBlog div.TzBlogInner h3.TzBlogTitle a,
    div.TzItemPage .TzArticleTitle a,
    div.TzPortfolioItemPage .TzArticleTitle a,
    .tz-content-inner h2 a,
    .tz-content-inner h3 a,
    .result-title,
    .group-title,
    h2,
    .accordion-heading .accordion-toggle,
    #TzContent .tz_item div.TzLink a {
      color: #000;
    }

    .sidebar-nav .box h3.header,
    .sidebar-nav h3,
    div.tz_portfolio_user h3.TzArticleAuthorTitle,
    div.TzRelated h3.TzRelatedTitle {
      color: #5a5a5a;
    }

    div.TzItemPage,
    div.TzPortfolioItemPage,
    .TzQuote .text,
    .tz_portfolio_user p,
    p,
    .myTab li a {
      color: #4f4f4f;
    }

    .box .content a:hover,
    .sidebar-nav li a:hover,
    .sidebar-nav li.active a,
    #plazart-mainnav .navbar .navbar-inner ul.nav li a:hover,
    #plazart-mainnav .navbar .navbar-inner ul.nav li.active>a,
    .contact .tz-contact-form h3,
    #tz_options .option-combo a.selected,
    #tz_options .option-combo a:hover,
    #off-canvas-nav li a:hover {
      color: #ff7200 !important;
    }

    #plazart-mainnav .navbar .navbar-inner ul.nav li a,
    .sidebar-nav li a,
    .sidebar-nav #tz_options a {
      color: #7b7b7b;
    }

    div#TzContent .tz_item .TzInner {
      height: 450px;
    }

    .tz-media-content {
      max-height: 450px;
    }

    .TZPorfolioMedium {
      max-height: 225px;
    }

    .dropdown-menu {
      background-color: #fff;
    }

    .TzSocialLinkTwitter {
      color: #8bc9e6 !important;
    }

    .TzSocialLinkFacebook {
      color: #7f91bc !important;
    }

    .TzSocialLinkGoogle {
      color: #ec7b71 !important;
    }

    .tz-border-bottom,
    .tz-border-top,
    .tz-border-right,
    .tz-border-left,
    .search,
    .sidebar-nav li a,
    div#tztwd-container .tztwd-tweet-container,
    .plazart-megamenu .dropdown>.dropdown-menu,
    #plazart-mainnav .navbar .navbar-inner ul.nav li .nav-child .mega-col-nav ul li.mega-group a,
    .plazart-megamenu .border-left>.mega-inner,
    .plazart-megamenu .span12.mega-col-nav .mega-inner ul.level1>li a,
    .sidebar-nav #tz_options a,
    div.tz_portfolio_user,
    div.TzRelated,
    div legend,
    .tz-partner>p,
    div table tr,
    .table-bordered th,
    .table-bordered td,
    .accordion-heading .accordion-toggle,
    #pricing-table-2 .column ul li,
    #pricing-table-2 .column {
      border-color: #e2e6e7 !important;
    }
  </style>
  <script src="/media/system/js/mootools-core.js" type="text/javascript"></script>
  <script src="/media/system/js/core.js" type="text/javascript"></script>
  <script src="/media/system/js/caption.js" type="text/javascript"></script>
  <script src="//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.3" type="text/javascript"></script>
  <script src="/media/jui/js/jquery.min.js" type="text/javascript"></script>
  <script src="/media/jui/js/jquery-noconflict.js" type="text/javascript"></script>
  <script src="/plugins/system/plazart/base/bootstrap/js/bootstrap.js" type="text/javascript"></script>
  <script src="/plugins/system/plazart/base/js/off-canvas.js" type=""></script>
  <script src="/plugins/system/plazart/base/js/script.js" type="text/javascript"></script>
  <script src="/plugins/system/plazart/base/js/menu.js" type="text/javascript"></script>
  <script src="/templates/tz_dreame/js/page.js" type="text/javascript"></script>
  <script src="/templates/tz_dreame/js/jquery.easing.1.3.js" type="text/javascript"></script>
  <script src="/templates/tz_dreame/js/tz_dreame.js" type="text/javascript"></script>
  <script src="/templates/tz_dreame/js/jquery.backgroundSize.js" type="text/javascript"></script>
  <script src="/templates/tz_dreame/js/jquery.ui.totop.js" type="text/javascript"></script>
  <script src="/media/com_acymailing/js/acymailing_module.js?v=494" type="text/javascript"></script>

  <meta property="og:title" content="Tantra's Origins" />
  <meta property="og:url" content="http://dhyanpraveshika.org/index.php/175-tantra-s-origins" />
  <meta property="og:description"
    content="ORIGINS In the 1st millennium AD, from the Vedic Traditions, Hinduism was developed into the long-established traditions we see today. Around the same time when..." />





  <link rel="stylesheet" href="/templates/tz_dreame/libraries/assets/socalicon/specimen_files/specimen_stylesheet.css"
    type="text/css" charset="utf-8" />
  <link rel="stylesheet" href="/templates/tz_dreame/libraries/assets/socalicon/stylesheet.css" type="text/css"
    charset="utf-8" />

  <link rel="stylesheet" href="/templates/tz_dreame/libraries/assets/font-awesome/css/font-awesome.min.css" />
  <!--[if IE 9]>
<link rel="stylesheet" href="/templates/tz_dreame/css/themes/block/ie9.css" type="text/css" />
<![endif]-->

  <!--[if IE 8]>
<link rel="stylesheet" href="/templates/tz_dreame/css/themes/block/ie8.css" type="text/css" />
<![endif]-->

  <!--[if lte IE 7]>
<link rel="stylesheet" href="/templates/tz_dreame/css/ie7.css" type="text/css" />
<link rel="stylesheet" href="/templates/tz_dreame/libraries/assets/font-awesome/css/font-awesome-ie7.min.css"/>
<![endif]-->

  <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
  <!--[if lt IE 9]>
<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

  <!-- For IE6-8 support of media query -->
  <!--[if lt IE 9]>
<script type="text/javascript" src="/plugins/system/plazart/base/js/respond.min.js"></script>
<![endif]-->



  <div id="fb-root"></div>

</head>

<body>


  <header class="tz-header">
    <div class="row-fluid">
      <div class="container-fluid">
        <div class="tz-inner tz-border-bottom">
          <div class="row-fluid">
            <div class="tz-logo span2">
              <h1 class="tz-logo pull-left">

                <a href="/./" id="tz-logo pull-left">
                  <img src="http://dhyanpraveshika.org//images/dhyan praveshika_logo.png"
                    alt="Dhyan Praveshika - The Spiritual Magazine  - " />
                </a>
              </h1>
            </div>

            <div class="tz_mainmenu span8">
              <nav id="plazart-mainnav" class="wrap plazart-megamenu navbar-collapse-fixed-top">
                <div class="row-fluid">
                  <div class="container-fluid">
                    <div class="tz-inner">
                      <div class="container navbar ">
                        <div class="navbar-inner">
                          <button type="button" class="btn btn-navbar" data-toggle="collapse"
                            data-target=".nav-collapse">
                            <i class="icon-reorder"></i>
                          </button>
                          <div class="nav-collapse collapse always-show">
                            <div class="plazart-megamenu">
                              <ul class="nav level0">
                                <li class="current active" data-id="198" data-level="1">
                                  <a class="" href="/">Home </a>
                                </li>
                                <li data-id="161" data-level="1">
                                  <a class="" href="/index.php/about-us">About Us </a>
                                </li>
                                <li class="dropdown mega" data-id="197" data-level="1">
                                  <a class=" dropdown-toggle" href="/index.php/readingroom"
                                    data-toggle="dropdown">LIBRARY </a><b class="caret"></b>
                                  <div class="nav-child dropdown-menu mega-dropdown-menu">
                                    <div class="row-fluid">
                                      <div class="span12 mega-col-nav" data-width="12">
                                        <div class="mega-inner">
                                          <ul class="mega-nav level1">
                                            <li class="dropdown-submenu mega" data-id="111" data-level="2">
                                              <a class="" href="/index.php/readingroom/magazine">MAGAZINE </a>
                                              <div class="nav-child dropdown-menu mega-dropdown-menu">
                                                <div class="row-fluid">
                                                  <div class="span12 mega-col-nav" data-width="12">
                                                    <div class="mega-inner">
                                                      <ul class="mega-nav level2">
                                                        <li data-id="163" data-level="3">
                                                          <a class=""
                                                            href="/index.php/readingroom/magazine/current-issue">Current
                                                            Issue </a>
                                                        </li>
                                                        <li class="dropdown-submenu mega" data-id="165" data-level="3">
                                                          <a class=""
                                                            href="/index.php/readingroom/magazine/archives">Archives
                                                          </a>
                                                          <div class="nav-child dropdown-menu mega-dropdown-menu">
                                                            <div class="row-fluid">
                                                              <div class="span12 mega-col-nav" data-width="12">
                                                                <div class="mega-inner">
                                                                  <ul class="mega-nav level3">
                                                                    <li data-id="166" data-level="4">
                                                                      <a class=""
                                                                        href="/index.php/readingroom/magazine/archives/december">December
                                                                      </a>
                                                                    </li>
                                                                    <li data-id="167" data-level="4">
                                                                      <a class=""
                                                                        href="/index.php/readingroom/magazine/archives/january">January
                                                                      </a>
                                                                    </li>
                                                                    <li data-id="168" data-level="4">
                                                                      <a class=""
                                                                        href="/index.php/readingroom/magazine/archives/february">February
                                                                      </a>
                                                                    </li>
                                                                  </ul>
                                                                </div>
                                                              </div>
                                                            </div>
                                                          </div>
                                                        </li>
                                                      </ul>
                                                    </div>
                                                  </div>
                                                </div>
                                              </div>
                                            </li>
                                            <li data-id="110" data-level="2">
                                              <a class="" href="/index.php/readingroom/contribute">CONTRIBUTE </a>
                                            </li>
                                            <li data-id="216" data-level="2">
                                              <a class="" href="/index.php/readingroom/articles">ARTICLES </a>
                                            </li>
                                          </ul>
                                        </div>
                                      </div>
                                    </div>
                                  </div>
                                </li>
                                <li data-id="169" data-level="1">
                                  <a class="" href="/index.php/videos">videos </a>
                                </li>
                                <li data-id="109" data-level="1">
                                  <a class="" href="/index.php/subscribe">SUBSCRIBE </a>
                                </li>
                                <li data-id="162" data-level="1">
                                  <a class="" href="/index.php/donate">DONATE </a>
                                </li>
                                <li data-id="113" data-level="1">
                                  <a class="" href="/index.php/contact">Contact </a>
                                </li>
                              </ul>
                            </div>
                          </div>
                        </div>
                      </div>

                      <div class="clr"></div>
                    </div>
                  </div>
                </div>

              </nav>
            </div>

          </div>

          <div class="clr"></div>
        </div>
      </div>
    </div>
  </header>

  <!--    -->
  <form:form modelAttribute="blog">
  <section id="tz-main" xmlns="http://www.w3.org/1999/html">
    <section class="tz-main-body">
      <div class="container-fluid">
        <div class="tz-inner">

          <section class="tz-content-wrap row-fluid">

            <section id="tz-content" class=" span10 offset2">

              <section id="tz-component" class="row-fluid">
                <div class=" tz-inner-content span ">

                  <div class="TzPortfolioItemPage item-page">
                    <div class="TzItemPageInner">

                      <div class="tzDetailContent">

                        <h2 class="TzArticleTitle">
                        ${blog.title}
                        </h2>


                        <div class="TzArticleInfo">

                          <span class="TzCreate">
                            ${blog.created_date}</span>


                          <span class="TzCreatedby">
                            <span class="TzLine">//</span>
                            By <a href="/index.php/users/365-dhyan-praveshika-team">${blog.author}</a> </span>

                          <span class="TzArticleCategory">
                            <span class="TzLine">//</span>
                            <a href="/">${blog.category}</a> </span>
                          <div class="clr"></div>
                        </div>
                        
                        <div class="TzArticleDescription">
                          <p><img src="data:image/${blog.extension};base64,${blog.encodedString}" alt="" /></p>
                          <p class="MsoNormal">
                          ${blog.description}
                          </p>                        
                         </div>
                        <div class="clr"></div>

                      </div>

                    </div>
                  </div>


                </div>



              </section>

            </section>

          </section>

        </div>
      </div>
    </section>
  </section>
 </form:form>

</body>

</html>