<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <!--Modal edit View Article-->
  <div class="modal fade" id="editViewArticleModal" role="dialog">
    <div class="modal-dialog modal-lg">

      <!-- Modal content-->
      <div class="modal-content">
      
      <!-- add new Articale --> 
        <form action="/addArticle" method="post" enctype="multipart/form-data">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title">Add New Article</h4>
          </div>
          <div class="modal-body">
			<input type="hidden" id="id" name="id">
            <div class="form-group">
              <label>Article Title</label>
              <input id="articleTital" type="text"  id="articleTital" name="articleTital" class="form-control">
            </div>
            
            <img class="img-thumbnail" id="image"  style="display:none"/>
            
            <div class="form-group">
              <label>Event Image</label>
              <div class="input-group">
                <input id="hiddenFileOpner" class="hidden" type="file" name="file" class="form-control"
                  placeholder="Select Image...">
                <input id="imageNameShowBox" type="text" class="form-control" placeholder="Select Image..." readonly>
                <span class="input-group-btn" id="articleSelectImage">
                  <button class="btn btn-default" type="button">Browse</button>
                </span>
              </div><!-- /input-group -->
            </div>

            <div class="form-group">
              <label>Creator Name</label>
              <input type="text" id="authorName" name="authorName" class="form-control">
            </div>
            
            <div class="form-group">
              <label>Category</label>
              <input type="text" id="category" name="category" class="form-control">
            </div>

            <div class="form-group">
              <label>Article</label>
              <textarea id="editor12" id="articleDescription" name="articleDescription" rows="10" cols="80">
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
 