<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Servicio en Ejecución</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .status-card {
            border-radius: 15px;
            border: none;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.08);
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-12 col-md-6 col-lg-5">
                <div class="card status-card text-center py-4">
                    <div class="card-body">

                        <div class="mb-3">
                            <i class="fas fa-server fa-3x text-primary"></i>
                        </div>
                        
                        <h2 class="fw-bold text-dark mb-3">
                            Servicio Activo
                        </h2>
                        
                        <p class="text-muted mb-4">
                            El servicio REST está ejecutándose correctamente
                        </p>
                        
                        <div class="mb-4">
                            <span class="badge bg-success fs-6 py-2 px-3">
                                <i class="fas fa-check-circle me-1"></i> EN EJECUCIÓN
                            </span>
                        </div>
                        
                        <div class="border-top pt-3 mt-3">
                            <div class="row text-center">
                                <div class="col-6">
                                    <small class="text-muted d-block">Aplicación</small>
                                    <strong>ServiciosWebProyecto</strong>
                                </div>
                                <div class="col-6">
                                    <small class="text-muted d-block">Contexto</small>
                                    <strong>/resources</strong>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div class="card-footer bg-transparent border-0 pt-0">
                        <small class="text-muted">
                            <i class="fas fa-clock me-1"></i>
                            <span id="currentTime"></span>
                        </small>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    
    <script>
        function updateTime() {
            const now = new Date();
            document.getElementById('currentTime').textContent = now.toLocaleString();
        }
        
        updateTime();
        setInterval(updateTime, 1000);
    </script>
</body>
</html>