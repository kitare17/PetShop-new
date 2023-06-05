
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<nav class="nav nav-pills nav-justified">
    <a class="nav-item nav-link active" href="#">Active</a>
    <a class="nav-item nav-link" href="#">Link</a>
    <a class="nav-item nav-link" href="#">Link</a>
    <a class="nav-item nav-link disabled" href="#">Disabled</a>
</nav>
<div class="container mt-3">
    <h2>Filterable Table</h2>
    <p>Type something in the input field to search the table for first names, last names or emails:</p>
    <input class="form-control" id="myInput" type="text" placeholder="Search..">
    <br>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Email</th>
        </tr>
        </thead>
        <tbody id="myTable">
        <tr>
            <td>John</td>
            <td>Doe</td>
            <td>john@example.com</td>
        </tr>
        <tr>
            <td>Mary</td>
            <td>Moe</td>
            <td>mary@mail.com</td>
        </tr>
        <tr>
            <td>July</td>
            <td>Dooley</td>
            <td>july@greatstuff.com</td>
        </tr>
        <tr>
            <td>Anja</td>
            <td>Ravendale</td>
            <td>a_r@test.com</td>
        </tr>
        </tbody>
    </table>

    <p>Note that we start the search in tbody, to prevent filtering the table headers.</p>
</div>

<script>
    $(document).ready(function(){
        $("#myInput").on("keyup", function() {
            var value = $(this).val().toLowerCase();
            $("#myTable tr").filter(function() {
                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
            });
        });
    });
</script>


