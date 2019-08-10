<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <script src="lib/jquery/jquery.min.js"></script>
  <!-- Bootstrap 3.3.7 -->
  <!-- <script src="lib/bootstrap/js/bootstrap.min.js"></script> -->
  <script src="/lib/bootstrap/js/bootstrap.min.js"/>
  <!-- Data table -->
  <script src="lib/data-tables/js/datatables.min.js"></script>
  <!-- CK Editor -->
  <script src="lib/ckeditor/ckeditor.js"></script>
  <script src="lib/ckeditor/config.js"></script>
 
  <!--Modal edit View Article-->
  <div class="modal fade" id="editViewArticleModal" role="dialog">
    <div class="modal-dialog modal-lg">

      <!-- Modal content-->
      <div class="modal-content">
      
      <!-- add new Articale --> 
        <form action="/addArticle" method="post" >
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title">Add New Article</h4>
          </div>
          <div class="modal-body">

            <div class="form-group">
              <label>Article Title</label>
              <input type="text"  name="articleTital" class="form-control">
            </div>

            <div class="form-group">
              <label>Creator Name</label>
              <input type="text" name="authorName" class="form-control">
            </div>
            
            <div class="form-group">
              <label>Category</label>
              <input type="text" name="category" class="form-control">
            </div>

            <div class="form-group">
              <label>Article</label>
              <textarea id="editor12" name="articleDescription" rows="10" cols="80">
               
              </textarea>
            </div>
	</div>
          <div class="modal-footer">
            <input type="submit" class="btn btn-primary" value = "Save"/>
            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
          </div>
        </form>
      </div>
    </div>
  </div>