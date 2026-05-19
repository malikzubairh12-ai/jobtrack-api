# JobTrack API Examples

Create application:

```bash
curl -X POST http://localhost:8081/api/applications \
  -H "Content-Type: application/json" \
  -d '{"company":"SAP","position":"Java Backend Werkstudent","location":"Walldorf","salaryRange":"16-20 EUR/h","status":"APPLIED","appliedDate":"2026-06-01","notes":"Applied with GitHub link"}'
```

Get all:

```bash
curl http://localhost:8081/api/applications
```

Search company:

```bash
curl "http://localhost:8081/api/applications/search?company=SAP"
```

Stats:

```bash
curl http://localhost:8081/api/applications/stats
```
