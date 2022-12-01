<?php

namespace App\Http\Controllers;

use App\Models\Potensi;
use Illuminate\Http\Request;

class PotensiController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $potensis = Potensi::paginate(10);
        return response()->json([
            'data' => $potensis
        ]);
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $potensi = Potensi::create([
            'judul' => $request->judul,
            'foto' => $request->foto,
            'shortdesc' => $request->shortdesc,
            'fulldesc' => $request->fulldesc,
            'categories' => $request->categories,
        ]);
        return response()->json([
            'data' => $potensi
        ]);
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Models\Potensi  $potensi
     * @return \Illuminate\Http\Response
     */
    public function show(Potensi $potensi)
    {
        return response()->json([
            'data' => $potensi
        ]);
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\Potensi  $potensi
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, Potensi $potensi)
    {
        $potensi->judul = $request->judul;
        $potensi->foto = $request->foto;
        $potensi->shortdesc = $request->shortdesc;
        $potensi->fulldesc = $request->fulldesc;
        $potensi->categories = $request->categories;
        $potensi->save();

        return response()->json([
            'data' => $potensi
        ]);
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\Potensi  $potensi
     * @return \Illuminate\Http\Response
     */
    public function destroy(Potensi $potensi)
    {
        $potensi->delete();
        return response()->json([
            'message' => 'data deleted'
        ], 204);
    }
}
